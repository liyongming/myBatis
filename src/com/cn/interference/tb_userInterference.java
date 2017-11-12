package com.cn.interference;

import com.cn.po.tb_user;

/**
 *@tb_user.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月12日
 *@下午3:51:37
 *@TODO
 */

public interface tb_userInterference {
	public tb_user selectById(String id);
	public tb_user selectAll();
	public int updateUserById();
	public int deleteUserById();
	
}
