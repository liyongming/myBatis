package com.cn.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *@sqlSessionFactory.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月12日
 *@下午3:54:30
 *@TODO
 */

public class sqlSessionFactory {
	/**
	 * 得到sqlSessionFactory的方法
	 * @throws IOException 
	 */
	public static SqlSession getSqlSession(){
		InputStream in;
		SqlSession session = null;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			session = sqlSessionFactory.openSession();
		} catch (IOException e) {
			 new IOException("获取sqlSessionFactory失败");
		}
		return session;
	}
}
