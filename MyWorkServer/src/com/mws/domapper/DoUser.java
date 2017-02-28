package com.mws.domapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mws.domain.User;

public class DoUser {

	public static User selectUserByName(SqlSession sqlSession, String userName) {

		String strMapperID = "com.mws.mapping.userMapper.selectUserByName";
		User user = sqlSession.selectOne(strMapperID, userName);
		sqlSession.commit();
		return user;

	}

	public static User selectUserBySysID(SqlSession sqlSession, int userSysID) {

		String strMapperID = "com.mws.mapping.userMapper.selectUserBySysID";
		User user = sqlSession.selectOne(strMapperID, userSysID);
		sqlSession.commit();
		return user;

	}

	public static List<User> selectUser(SqlSession sqlSession) {

		String strMapperID = "com.mws.mapping.userMapper.selectUser";
		List<User> users = sqlSession.selectList(strMapperID);
		sqlSession.commit();
		return users;

	}

	public static int insertUser(SqlSession sqlSession, User user) {

		String strMapperID = "com.mws.mapping.userMapper.insertUser";
		int i = 0;

		try {
			i = sqlSession.insert(strMapperID, user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			i = 0;
			// e.printStackTrace();
		}
		sqlSession.commit();
		return i;

	}

	public static int updateUser(SqlSession sqlSession, User user) {

		String strMapperID = "com.mws.mapping.userMapper.updateUser";
		int i = sqlSession.update(strMapperID, user);
		sqlSession.commit();
		return i;

	}

	public static int deleteUser(SqlSession sqlSession, long userID) {

		String strMapperID = "com.mws.mapping.userMapper.deleteUser";
		int i = sqlSession.delete(strMapperID, userID);
		sqlSession.commit(true);
		return i;

	}

}
