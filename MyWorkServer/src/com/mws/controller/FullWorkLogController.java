package com.mws.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mws.domain.WorkLog;
import com.mws.domain.WorkType;
import com.mws.domapper.DoWorkLog;
import com.mws.domapper.DoWorkType;

@Controller
public class FullWorkLogController {

	SqlSession sqlSession = InitSqlSession.getSqlSession();

	@ResponseBody
	@RequestMapping(value = "/queryFullWorkLog.do")
	public Map<String, Object> QueryFullWorkLog(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));

		Map<String, Object> fullWorkType = new HashMap<String, Object>();
		List<Map<String, Object>> workLogMap = new ArrayList<Map<String, Object>>();

		List<WorkLog> workLogs = DoWorkLog.selectWorkLog(sqlSession, userID);

		for (WorkLog workLog : workLogs) {
			long workLogID = workLog.getWorkLogID();
			long longTime = workLog.getLongTime();
			long workTypeID = workLog.getWorkTypeID();
			WorkType mWorkType = DoWorkType.selectWorkTypeByID(sqlSession,
					workTypeID);
			String WorkContent = workLog.getWorkContent();

			Map<String, Object> mWorkLog = new HashMap<String, Object>();
			mWorkLog.put("userID", userID);
			mWorkLog.put("workLogID", workLogID);
			mWorkLog.put("longTime", longTime);
			mWorkLog.put("workType", mWorkType);
			mWorkLog.put("workContent", WorkContent);

			workLogMap.add(mWorkLog);

		}
		fullWorkType.put("workLogs", workLogMap);
		return fullWorkType;

	}

	@ResponseBody
	@RequestMapping(value = "/queryLogByTime.do")
	public Map<String, Object> QueryLogbyTime(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		long minLongTime = Long.parseLong(request.getParameter("minLongTime"));
		long maxLongTime = Long.parseLong(request.getParameter("maxLongTime"));

		Map<String, Long> parameterMap = new HashMap<String, Long>();
		parameterMap.put("userID", userID);
		parameterMap.put("minLongTime", minLongTime);
		parameterMap.put("maxLongTime", maxLongTime);

		Map<String, Object> fullWorkType = new HashMap<String, Object>();
		List<Map<String, Object>> workLogMap = new ArrayList<Map<String, Object>>();

		List<WorkLog> workLogs = DoWorkLog.selectWorkLogByTime(sqlSession,
				parameterMap);

		for (WorkLog workLog : workLogs) {
			long workLogID = workLog.getWorkLogID();
			long longTime = workLog.getLongTime();
			long workTypeID = workLog.getWorkTypeID();
			WorkType mWorkType = DoWorkType.selectWorkTypeByID(sqlSession,
					workTypeID);
			String WorkContent = workLog.getWorkContent();

			Map<String, Object> mWorkLog = new HashMap<String, Object>();
			mWorkLog.put("userID", userID);
			mWorkLog.put("workLogID", workLogID);
			mWorkLog.put("longTime", longTime);
			mWorkLog.put("workType", mWorkType);
			mWorkLog.put("workContent", WorkContent);

			workLogMap.add(mWorkLog);

		}
		fullWorkType.put("workLogs", workLogMap);
		return fullWorkType;
	}

	@ResponseBody
	@RequestMapping(value = "/queryLogByTypeAndTime.do")
	public Map<String, Object> QueryLogByTypeAndTime(
			HttpServletRequest request, HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		long queryTypeID = Long.parseLong(request.getParameter("queryTypeID"));
		long minLongTime = Long.parseLong(request.getParameter("minLongTime"));
		long maxLongTime = Long.parseLong(request.getParameter("maxLongTime"));

		Map<String, Long> parameterMap = new HashMap<String, Long>();
		parameterMap.put("userID", userID);
		parameterMap.put("workTypeID", queryTypeID);
		parameterMap.put("minLongTime", minLongTime);
		parameterMap.put("maxLongTime", maxLongTime);

		Map<String, Object> fullWorkType = new HashMap<String, Object>();
		List<Map<String, Object>> workLogMap = new ArrayList<Map<String, Object>>();

		List<WorkLog> workLogs = DoWorkLog.selectWorkLogByType(sqlSession,
				parameterMap);

		for (WorkLog workLog : workLogs) {
			long workLogID = workLog.getWorkLogID();
			long longTime = workLog.getLongTime();
			long workTypeID = workLog.getWorkTypeID();
			WorkType mWorkType = DoWorkType.selectWorkTypeByID(sqlSession,
					workTypeID);
			String WorkContent = workLog.getWorkContent();

			Map<String, Object> mWorkLog = new HashMap<String, Object>();
			mWorkLog.put("userID", userID);
			mWorkLog.put("workLogID", workLogID);
			mWorkLog.put("longTime", longTime);
			mWorkLog.put("workType", mWorkType);
			mWorkLog.put("workContent", WorkContent);

			workLogMap.add(mWorkLog);

		}
		fullWorkType.put("workLogs", workLogMap);
		return fullWorkType;

	}

}
