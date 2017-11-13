package com.cn.interference.test;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.cn.interference.orderInterference;
import com.cn.po.tb_order;
import com.cn.util.sqlSessionFactory;

/**
 *@orderTest.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月13日
 *@下午7:09:48
 *@TODO
 */

public class orderTest {
	/**
	 * 测试编写的接口是否可以使用
	 */
	@Test
	public void testSelectOrder(){
		SqlSession sqlSession = sqlSessionFactory.getSqlSession();
		orderInterference orderMapper = sqlSession.getMapper(orderInterference.class);
		tb_order testSelect = orderMapper.testSelect(1);
		System.out.println(testSelect.getId()+"---"+testSelect.getCode()+"----"+testSelect.getTotal());
	};
	/**
	 * 测试
	 */
	@Test
	public void testSelect_If(){
		SqlSession sqlSession = sqlSessionFactory.getSqlSession();
		orderInterference orderMapper = sqlSession.getMapper(orderInterference.class);
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("id", 6);
		List<tb_order> select_If = orderMapper.select_If(params);
		for (tb_order testSelect : select_If) {
			System.out.println(testSelect.getId()+"---"+testSelect.getCode()+"----"+testSelect.getTotal());
		}
	}
	@Test
	public void testSelectWhereAndWhen(){
		SqlSession sqlSession = sqlSessionFactory.getSqlSession();
		orderInterference mapper = sqlSession.getMapper(orderInterference.class);
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("total", 110);
		List<tb_order> orderList = mapper.select_choose(params);
		for (tb_order tb_order : orderList) {
			System.out.println(tb_order.getId());
		}
	}
}
