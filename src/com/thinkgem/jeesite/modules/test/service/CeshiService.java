/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test.entity.Ceshi;
import com.thinkgem.jeesite.modules.test.dao.CeshiDao;

/**
 * 测试Service
 * @author ThinkGem
 * @version 2016-04-20
 */
@Service
@Transactional(readOnly = true)
public class CeshiService extends CrudService<CeshiDao, Ceshi> {

	public Ceshi get(String id) {
		return super.get(id);
	}
	
	public List<Ceshi> findList(Ceshi ceshi) {
		return super.findList(ceshi);
	}
	
	public Page<Ceshi> findPage(Page<Ceshi> page, Ceshi ceshi) {
		return super.findPage(page, ceshi);
	}
	
	@Transactional(readOnly = false)
	public void save(Ceshi ceshi) {
		super.save(ceshi);
	}
	
	@Transactional(readOnly = false)
	public void delete(Ceshi ceshi) {
		super.delete(ceshi);
	}
	
}