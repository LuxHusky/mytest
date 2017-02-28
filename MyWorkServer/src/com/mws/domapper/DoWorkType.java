package com.mws.domapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mws.domain.WorkType;

public class DoWorkType {

	public static List<WorkType> selectWorkType(SqlSession sqlSession) {

		String strMapperID = "com.mws.mapping.workTypeMapper.selectWorkType";
		List<WorkType> workTypes = sqlSession.selectList(strMapperID);
		sqlSession.commit();
		return workTypes;
	}

	public static WorkType selectWorkTypeByID(SqlSession sqlSession,
			long workTypeID) {

		String strMapperID = "com.mws.mapping.workTypeMapper.selectWorkTypeByID";
		WorkType workType = sqlSession.selectOne(strMapperID, workTypeID);
		sqlSession.commit();
		return workType;

	}

	public static WorkType selectWorkTypeByName(SqlSession sqlSession,
			String workTypeName) {
		
		String strMapperID="com.mws.mapping.workTypeMapper.selectWorkTypeByName";
		WorkType workType=sqlSession.selectOne(strMapperID, workTypeName);
		sqlSession.commit();
		return workType;

	}

	public static int insertWorkType(SqlSession sqlSession, WorkType workType) {

		String strMapperID = "com.mws.mapping.workTypeMapper.insertWorkType";
		int i;
		try {
			i = sqlSession.insert(strMapperID, workType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			i = 0;
			// e.printStackTrace();
		}
		sqlSession.commit();

		return i;

	}

	public static int updateWorkType(SqlSession sqlSession, WorkType workType) {

		String strMapperID = "com.mws.mapping.workTypeMapper.updateWorkType";
		int i;
		try {
			i = sqlSession.update(strMapperID, workType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			i = 0;
			// e.printStackTrace();
		}
		sqlSession.commit();

		return i;

	}

	public static int deleteWorkType(SqlSession sqlSession, long workTypeID) {

		String strMapperID = "com.mws.mapping.workTypeMapper.deleteWorkType";
		int i = sqlSession.delete(strMapperID, workTypeID);
		sqlSession.commit(true);
		return i;
	}
}
