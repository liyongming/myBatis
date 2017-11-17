package com.cn.interference.test;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.cn.interference.orderInterference;
import com.cn.po.tb_article;
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
	/**
	 * 多对多的关系实现的太差劲，没有实现自动加载的效果,
	 * 现在测试时，根据用户ID查询出订单，如果查询出多条记录的情况下，需要在主表。用户表中进行定义，
	 * userMapper.xml
	 *    <user><collection oftype="tb_order"><collection oftype="tb_articles"></collection></collection></user>
	 * @throws Exception
	 */
	@Test
	public void testSelectByOrderId() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.getSqlSession();
		orderInterference mapper = sqlSession.getMapper(orderInterference.class);
		List<tb_order> selectOrderByUserId = mapper.selectOrderByUserId("1");
		for (tb_order tb_order : selectOrderByUserId) {
			System.out.println(tb_order.getCode()+"---"+tb_order.getId());
			List<tb_article> selectList = sqlSession.selectList("com.cn.interference.articleInterference.selectArticleByOrderId", tb_order.getId());
			for (tb_article tb_article : selectList) {
				System.out.println(tb_article.getName()+"商品价钱"+tb_article.getPrice());
			}
		}
	}
	/**
	 * 根据订单ID去查询商品信息,
	 * 在此处根据订单Id查询出订单，去查询商品的时候，使用的是column的值如何确定，可以测试，将数据库查询出的值改为不通的列，
	 * 发现查询出的结果确实是根据数据库的列名字进行定义的
	 * @throws Exception
	 */
	@Test
	public void testSelectB() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.getSqlSession();
		orderInterference mapper = sqlSession.getMapper(orderInterference.class);
		tb_order testSelect = mapper.testSelect(2);
		List<tb_article> articles = testSelect.getArticles();
		for (tb_article tb_article : articles) {
			System.out.println(tb_article.getName()+tb_article.getPrice());
		}
	}
}
