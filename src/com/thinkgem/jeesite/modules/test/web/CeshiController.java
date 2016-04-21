/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.test.entity.Ceshi;
import com.thinkgem.jeesite.modules.test.service.CeshiService;

/**
 * 测试Controller
 * @author ThinkGem
 * @version 2016-04-20
 */
@Controller
@RequestMapping(value = "${adminPath}/test/ceshi")
public class CeshiController extends BaseController {

	@Autowired
	private CeshiService ceshiService;
	
	@ModelAttribute
	public Ceshi get(@RequestParam(required=false) String id) {
		Ceshi entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ceshiService.get(id);
		}
		if (entity == null){
			entity = new Ceshi();
		}
		return entity;
	}
	
	@RequiresPermissions("test:ceshi:view")
	@RequestMapping(value = {"list", ""})
	public String list(Ceshi ceshi, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Ceshi> page = ceshiService.findPage(new Page<Ceshi>(request, response), ceshi); 
		model.addAttribute("page", page);
		return "modules/test/ceshiList";
	}

	@RequiresPermissions("test:ceshi:view")
	@RequestMapping(value = "form")
	public String form(Ceshi ceshi, Model model) {
		model.addAttribute("ceshi", ceshi);
		return "modules/test/ceshiForm";
	}

	@RequiresPermissions("test:ceshi:edit")
	@RequestMapping(value = "save")
	public String save(Ceshi ceshi, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ceshi)){
			return form(ceshi, model);
		}
		ceshiService.save(ceshi);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+Global.getAdminPath()+"/test/ceshi/?repage";
	}
	
	@RequiresPermissions("test:ceshi:edit")
	@RequestMapping(value = "delete")
	public String delete(Ceshi ceshi, RedirectAttributes redirectAttributes) {
		ceshiService.delete(ceshi);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+Global.getAdminPath()+"/test/ceshi/?repage";
	}

}