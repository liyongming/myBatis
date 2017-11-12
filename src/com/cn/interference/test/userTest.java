package com.cn.interference.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.cn.po.tb_order;
import com.cn.po.tb_user;
import com.cn.util.sqlSessionFactory;

/**
 *@userTest.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月12日
 *@下午4:05:34
 *@TODO
 */

public class userTest {
	/**
	 * 测试使用接口开发，调用接口来进行数据库tb_user表的查询
	 * @error Cannot enable lazy loading because CGLIB is not available   ====>加入asm和cglib的jar包
	 */
	@Test
	public void selectTbStudentById(){
		SqlSession session = sqlSessionFactory.getSqlSession();
		System.out.println(session);
		tb_user user = session.selectOne("com.cn.interference.userMapper.selectById","2");
		List<tb_order> orders = user.getOrders();
		for(int i = 0;i<orders.size();i++){
			System.out.println(orders.get(i).getCode());
		}
	}
}
