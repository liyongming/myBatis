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
import com.cn.po.emp;

/**
 *@empAndDept.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月11日
 *@下午6:59:02
 *@TODO
 */

public class empAndDept {
	/**
	 * 查询出所有emp表中的数据，同时查询dept表的数据
	 * @throws IOException
	 */
	@Test
	public void selectEmp_Dept() throws IOException{
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<emp> listemp = sqlSession.selectList("com.cn.mapper.empAndDept.selectStudent");
		for(int i = 0;i<listemp.size();i++){
			System.out.println(listemp.get(i));
		}
		sqlSession.close();
	}
	/**
	 * 查询部门中的所有的员工
	 * @throws IOException
	 */
	@Test
	public void selectDept_Select_Emp() throws IOException{
		
		InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<deptB> deptList = sqlSession.selectList("com.cn.mapper.deptSelectEmp.selectDept");
		for(int i=0;i<deptList.size();i++){
			//循环遍历部门，拿到第一个部门的时候，得到部门1的所有的emp，然后遍历部门中的所有的员工
			System.out.println(deptList.get(i));
			List<emp> empList = deptList.get(i).getEmp();
			for(int j=0;j<empList.size();j++){
				System.out.println(deptList.get(i).getDeptno()+"--"+empList.get(j).getEname());
			}
		}
		sqlSession.close();
	}
}
