package com.mws.domapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mws.domain.MyUser;

public class DoMyUser {
	
	public static MyUser selectUserByName(SqlSession sqlSession, String userName) {

		String strMapperID = "com.mws.mapping.myuserMapper.selectUserByName";
		MyUser user = sqlSession.selectOne(strMapperID, userName);
		sqlSession.commit();
		return user;

	}

	public static MyUser selectUserByID(SqlSession sqlSession, int id) {
		String strMapperID = "com.mws.mapping.myuserMapper.selectUserByID";
		MyUser myuser = (MyUser) sqlSession.selectOne(strMapperID, id);
		sqlSession.commit();
		return myuser;

	}

	public static int deletUser(SqlSession sqlSession, int id) {
		String strMapperID = "com.mws.mapping.myuserMapper.deletUserByID";
		int i = 0;
		i = sqlSession.delete(strMapperID, id);
		sqlSession.commit();
		return i;
	}

	public static int updateUser(SqlSession sqlSession, MyUser myuser) {
		String strMapperID = "com.mws.mapping.myuserMapper.updateUserByID";
		int i = 0;
		i = sqlSession.update(strMapperID, myuser);
		sqlSession.commit();
		return i;
	}

	public static List<MyUser> selectAll(SqlSession sqlSession) {
		String strMapperID = "com.mws.mapping.myuserMapper.selectAll";
		List<MyUser> myuserList = sqlSession.selectList(strMapperID);
		sqlSession.commit();
		return myuserList;
	}

}
