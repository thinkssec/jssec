/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 测试Entity
 * @author ThinkGem
 * @version 2016-04-20
 */
public class Ceshi extends DataEntity<Ceshi> {
	
	private static final long serialVersionUID = 1L;
	private String col1L1;		// 列1
	private Long col2L2;		// col2_l2
	private Double col3L3J3;		// col3_l3_j3
	private Date col4;		// col4
	private Date col5;		// 列3
	private String col6;		// col6
	private String col7;		// col7
	
	public Ceshi() {
		super();
	}

	public Ceshi(String id){
		super(id);
	}

	@Length(min=0, max=20, message="列1长度必须介于 0 和 20 之间")
	public String getCol1L1() {
		return col1L1;
	}

	public void setCol1L1(String col1L1) {
		this.col1L1 = col1L1;
	}
	
	public Long getCol2L2() {
		return col2L2;
	}

	public void setCol2L2(Long col2L2) {
		this.col2L2 = col2L2;
	}
	
	public Double getCol3L3J3() {
		return col3L3J3;
	}

	public void setCol3L3J3(Double col3L3J3) {
		this.col3L3J3 = col3L3J3;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCol4() {
		return col4;
	}

	public void setCol4(Date col4) {
		this.col4 = col4;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCol5() {
		return col5;
	}

	public void setCol5(Date col5) {
		this.col5 = col5;
	}
	
	public String getCol6() {
		return col6;
	}

	public void setCol6(String col6) {
		this.col6 = col6;
	}
	
	public String getCol7() {
		return col7;
	}

	public void setCol7(String col7) {
		this.col7 = col7;
	}
	
}