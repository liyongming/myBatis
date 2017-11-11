package com.cn.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.cn.po.deptB;

/**
 *@empAndDept.java
 *@ emp表和dept表的结合使用
 *@myBatis
 *@author lym
 *@2017年11月11日
 *@下午5:33:28
 *@TODO
 */

public class dept {
	/**
	 * 查询部门号为10的部门
	 * @throws IOException
	 */
	@Test
	public void selectOneById() throws IOException{
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		deptB dept = sqlSession.selectOne("com.cn.mapper.deptMapper.selectOne",10);
		System.out.println(dept.toString());
		sqlSession.commit();
		sqlSession.close();
	}
	/**
	 * 查询所有的部门
	 * @throws IOException
	 */
	@Test
	public void selectAll() throws IOException{
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactory.openSession();
		List<deptB> dept = session.selectList("com.cn.mapper.deptMapper.selectAll");
		for(deptB dep:dept){
			System.out.println(dep);
		}
	}
	/**
	 * 插入数据
	 * @throws IOException
	 */
	@Test
	public void insertDept() throws IOException{
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactory.openSession();
		deptB dept = new deptB();
		dept.setDeptno(22);
		dept.setDname("xxxxxx");
		dept.setLoc("xxxxxx");
		int count = session.insert("com.cn.mapper.deptMapper.insert",dept);
		if(count > 0 ){
			System.out.println("插入数据库成功"+count);
		}
		session.commit();
		session.close();
	}
	/**
	 * 更新数据库
	 * @throws IOException
	 */
	@Test
	public void update() throws IOException{
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactory.openSession();
		deptB dept = new deptB();
		dept.setDeptno(22);
		dept.setDname("ggggggg");
		dept.setLoc("hhhhh");
		int count = session.update("com.cn.mapper.deptMapper.update", dept);
		if(count > 0 ){
			System.out.println("更新条数："+count);
		}
		session.commit();
		session.close();
	}
	/**
	 * 删除数据
	 * @throws IOException
	 */
	@Test
	public void delete() throws IOException{
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("com.cn.mapper.deptMapper.delete",22);
		session.commit();
		session.close();
	}
}
