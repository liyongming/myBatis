package com.cn.po;

/**
 *@tb_order.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月12日
 *@下午3:45:59
 *@TODO
 */

public class tb_order {
	private Integer id;
	private String code;
	private Integer total;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
