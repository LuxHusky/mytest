package com.mws.domapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mws.domain.WorkLog;

public class DoWorkLog {

	public static List<WorkLog> selectWorkLog(SqlSession sqlSession, long userID) {

		String strMapperID = "com.mws.mapping.workLogMapper.selectWorkLog";
		List<WorkLog> workLogs = sqlSession.selectList(strMapperID, userID);
		sqlSession.commit();
		return workLogs;

	}

	public static List<WorkLog> selectWorkLogByTime(SqlSession sqlSession,
			Map<String, Long> parameterMap) {

		String strMapperID = "com.mws.mapping.workLogMapper.selectWorkLogByTime";
		List<WorkLog> workLogs = sqlSession.selectList(strMapperID,
				parameterMap);
		sqlSession.commit();
		return workLogs;

	}

	public static List<WorkLog> selectWorkLogByType(SqlSession sqlSession,
			Map<String, Long> parameterMap) {

		String strMapperID = "com.mws.mapping.workLogMapper.selectWorkLogByType";
		List<WorkLog> workLogs = sqlSession.selectList(strMapperID,
				parameterMap);
		sqlSession.commit();
		return workLogs;

	}

	public static int insertWorkLog(SqlSession sqlSession, WorkLog workLog) {

		String strMapperID = "com.mws.mapping.workLogMapper.insertWorkLog";
		int i = sqlSession.insert(strMapperID, workLog);
		sqlSession.commit();
		return i;
	}

	public static int updateWorkLog(SqlSession sqlSession, WorkLog workLog) {

		String strMapperID = "com.mws.mapping.workLogMapper.updateWorkLog";
		int i = sqlSession.update(strMapperID, workLog);
		sqlSession.commit();
		return i;

	}

	public static int deleteWorkLog(SqlSession sqlSession, Long workLogID) {

		String strMapperID = "com.mws.mapping.workLogMapper.deleteWorkLog";
		int i = sqlSession.delete(strMapperID, workLogID);
		sqlSession.commit(true);
		return i;

	}

	public static int deleteworkLogByType(SqlSession sqlSession,
			Map<String, Long> parameterMap) {

		String strMapperID = "com.mws.mapping.workLogMapper.deleteWorkLogByType";
		int i = sqlSession.delete(strMapperID, parameterMap);
		sqlSession.commit(true);
		return i;

	}
}
