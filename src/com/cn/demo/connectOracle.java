package com.cn.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.cn.po.emp;

/**
 *@connectOracle.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月11日
 *@下午2:26:29
 *@TODO
 */

public class connectOracle {
	/**
	 * 查询一条记录
	 * 加载MyBatis配置文件
	 * @throws IOException 
	 */
	@Test
	public void loadConfXml() throws IOException{
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactory.openSession();
		String fasdfafds = "7369";
		emp emp = (emp)session.selectOne("com.cn.mapper.selectEmpByEmpno",fasdfafds);
		System.out.println(emp.getEmpno()+"--"+emp.getEname());
	}
	/** 
	 * 查询多条记录
	 * 加载配置文件并查询本地oracle数据库中的emp表的数据
	 * @throws IOException 
	 */
	@Test
	public void loadConfAndSelectEmp() throws IOException{
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactory.openSession();
		List<emp> empList = session.selectList("com.cn.mapper.selectAllEmp");
		for(int i =0;i<empList.size();i++){
			emp emp = empList.get(i);
			System.out.println(emp.toString());
			//System.out.println(emp.getEmpno()+"---"+emp.getEname());
		}
		//System.out.println("emp"+empList.size());
	}
	/**
	 * 插入一条数据
	 * 问题一：开始mappser.xml 中的parameterType写成了 上面定义的map的id，导致插入的时候出错了
	 * 问题二：在日志中打出的sql中明明已经出现了对应的insert语句，但是查询数据的时候并没有相应的数据，解决办法，把session  commit()
	 * @throws IOException
	 */
	@Test
	public void insertIntoEmp() throws IOException{
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactroy = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactroy.openSession();
		emp emp = new emp();
		emp.setEmpno(223);
		emp.setEname("小男孩");
		int count = session.insert("com.cn.mapper.inserts",emp);
		if(count > 0 ){
			System.out.println("更新的条数:"+count);
		}
		session.commit();
		session.close();
	}
	/**
	 * 更新一条数据
	 * @throws IOException
	 */
	@Test
	public void updateEmp() throws IOException{
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactory.openSession();
		emp emp = new emp();
		emp.setEmpno(223);
		emp.setEname("test");
		int count = session.update("com.cn.mapper.update", emp);
		if(count > 0 ){
			System.out.println("更新条数为："+count);
		}
		session.commit();
		session.close();
	}
	/**
	 * 删除一条数据
	 * @throws IOException
	 */
	@Test
	public void deleteEmp() throws IOException{
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactory.openSession();
		int count = session.delete("com.cn.mapper.delete","223");
		if(count > 0){
			System.out.println("删除成功："+count);
		}
		session.commit();
		session.close();
		
	}
}
