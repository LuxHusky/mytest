package com.mws.domapper;

import org.apache.ibatis.session.SqlSession;

import com.mws.domain.MyUser;

public class DoRegisterUser {
	public static int registUser(SqlSession sqlSession,MyUser myuser){
		String strID = "com.mws.mapping.myuserMapper.registUser";
		int i=0;
		i=sqlSession.insert(strID,myuser);
		sqlSession.commit();
		return i;
	}
}
