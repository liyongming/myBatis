package com.cn.interference;

import java.util.HashMap;
import java.util.List;

import com.cn.po.tb_order;

/**
 *@orderInterference.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月13日
 *@下午7:08:28
 *@TODO
 */

public interface orderInterference {
	public tb_order testSelect(int id);
	public List<tb_order> select_If(HashMap<String,Object> params);
	public List<tb_order> select_choose(HashMap<String,Object> params);
	public List<tb_order> selectOrderByUserId(String id);
}
