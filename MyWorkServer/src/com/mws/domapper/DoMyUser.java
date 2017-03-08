package com.mws.domapper;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import com.mws.domain.MyUser;

public class DoMyUser {
	public static MyUser selectUserByAccount(SqlSession sqlSession, String account){
		String strMapperID ="com.mws.mapping.myuserMapper.selectUserByAccount";
		MyUser myuser =sqlSession.selectOne(strMapperID, account);
		return myuser;
	}
	public static List<MyUser> selectUserByDepartment(SqlSession sqlSession, String department){
		String strMapperID ="com.mws.mapping.myuserMapper.selectUserByDepartment";
		List<MyUser> myuser  =	sqlSession.selectList(strMapperID, department);
		sqlSession.commit();
		return myuser;
	}
	
	public static List<MyUser> selectUserByName(SqlSession sqlSession, String userName) {

		String strMapperID = "com.mws.mapping.myuserMapper.selectUserByName";
		List<MyUser> user = sqlSession.selectList(strMapperID, userName);
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
	public static int updateSorce(SqlSession sqlSession,MyUser myUser){
		String strMapperID ="com.mws.mapping.myuserMapper.updateSorce";
		int i = sqlSession.update(strMapperID, myUser);
		sqlSession.commit();
		return i;
		
	}
	public static int unceupdate(SqlSession sqlSession,MyUser myUser){
		String strMapperID ="com.mws.mapping.myuserMapper.uncerUpdate";
		int i = sqlSession.update(strMapperID, myUser);
		sqlSession.commit();
		return i;
		
	}

}
