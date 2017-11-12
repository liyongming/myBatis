package com.cn.po;

/**
 *@tb_article.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月12日
 *@下午3:46:20
 *@TODO
 */

public class tb_article {
	private Integer article_id;
	private String name;
	private String remark;
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
