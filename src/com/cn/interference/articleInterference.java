package com.cn.interference;

import java.util.List;

import com.cn.po.tb_article;

/**
 *@articleInterference.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月16日
 *@下午6:41:52
 *@TODO
 */

public interface articleInterference {
	public List<tb_article> selectArticleByOrderId(int id) throws Exception;
}
