package com.cn.interference.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.cn.interference.tb_userInterference;
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
	/**
	 * 使用接口开发，需要使得接口名字，mapper.xml中的namespace中的名字，是一致的。
	 * 同时调用的方法，接口中的方法，和mapper.xml中的方法是一致的
	 */
	@Test
	public void selectStudentByInterfence(){
		SqlSession sqlSession = sqlSessionFactory.getSqlSession();
		tb_userInterference mapper = sqlSession.getMapper(tb_userInterference.class);
		tb_user user = mapper.selectById("2");
		List<tb_order> orders = user.getOrders();
		for(int i = 0;i<orders.size();i++){
			System.out.println(orders.get(i).getCode());
		}
	}
}
