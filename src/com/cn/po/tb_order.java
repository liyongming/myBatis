package com.cn.po;

import java.util.List;

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
	private List<tb_article> articles;
	
	public List<tb_article> getArticles() {
		return articles;
	}
	public void setArticles(List<tb_article> articles) {
		this.articles = articles;
	}
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
