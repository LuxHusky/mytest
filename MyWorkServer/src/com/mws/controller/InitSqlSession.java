package com.mws.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InitSqlSession {

	private InitSqlSession() {
		// TODO Auto-generated constructor stub
	}

	private static SqlSession sqlSession = null;

	public static synchronized SqlSession getSqlSession() {

		if (sqlSession == null) {

			String res = "config_mybatis.xml";

			try {
				InputStream is = Resources.getResourceAsStream(res);
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
						.build(is);

				sqlSession = sqlSessionFactory.openSession();
				
				return sqlSession;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sqlSession;

	}

}
