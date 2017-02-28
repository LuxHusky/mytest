package com.mws.domapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.mws.controller.UserTypeWithUserController;
import com.mws.domain.UserType;

public class DoUserType {

	public static int insertUserType(SqlSession sqlSession, UserType userType) {

		String strMapperID = "com.mws.mapping.userTypeMapper.insertUserType";
		int i;
		try {
			i = sqlSession.insert(strMapperID, userType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			i = 0;
			// e.printStackTrace();
		}
		sqlSession.commit();
		return i;

	}

	public static int deleteUserType(SqlSession sqlSession, UserType userType) {

		String strMapperID = "com.mws.mapping.userTypeMapper.deleteUserType";
		int i = sqlSession.delete(strMapperID, userType);
		sqlSession.commit(true);
		return i;

	}

	public static List<UserType> selectUserType(SqlSession sqlSession,
			long userID) {

		String strMapperID = "com.mws.mapping.userTypeMapper.selectUserType";

		List<UserType> userTypes = sqlSession.selectList(strMapperID, userID);
		// sqlSession.commit();
		return userTypes;

	}

	public static UserType checkUserType(SqlSession sqlSession,
			UserType userType) {

		String strMapperID = "com.mws.mapping.userTypeMapper.checkUserType";
		UserType exist_userType = sqlSession.selectOne(strMapperID, userType);
		sqlSession.commit();
		return exist_userType;

	}

	public static int updateUserType(SqlSession sqlSession,
			Map<String, Long> parameterMap) {

		String strMapperID = "com.mws.mapping.userTypeMapper.updateUserType";
		int i = sqlSession.update(strMapperID, parameterMap);
		sqlSession.commit();
		return i;

	}
}
