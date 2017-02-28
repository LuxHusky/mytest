package com.mws.controller;

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
import com.mws.domapper.DoWorkLog;

@Controller
public class WorkLogController {

	SqlSession sqlSession = InitSqlSession.getSqlSession();

	@ResponseBody
	@RequestMapping(value = "/selectWorkLog.do")
	public Map<String, Object> SelectWorkLog(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		Map<String, Object> workLogSelectMap = new HashMap<String, Object>();

		List<WorkLog> workLogs = DoWorkLog.selectWorkLog(sqlSession, userID);

		workLogSelectMap.put("workLogs", workLogs);
		return workLogSelectMap;
	}

	@ResponseBody
	@RequestMapping(value = "/selectWorkLogByTime.do")
	public Map<String, Object> SelectWorkLogByTime(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		long minLongTime = Long.parseLong(request.getParameter("minLongTime"));
		long maxLongTime = Long.parseLong(request.getParameter("maxLongTime"));

		Map<String, Object> workLogSelectMapByTime = new HashMap<String, Object>();

		Map<String, Long> parameterMap = new HashMap<String, Long>();
		parameterMap.put("userID", userID);
		parameterMap.put("minLongTime", minLongTime);
		parameterMap.put("maxLongTime", maxLongTime);

		List<WorkLog> workLogs = DoWorkLog.selectWorkLogByTime(sqlSession,
				parameterMap);

		workLogSelectMapByTime.put("workLogs", workLogs);
		return workLogSelectMapByTime;

	}

	@ResponseBody
	@RequestMapping(value = "/selectWorkTypeByType.do")
	public Map<String, Object> SelectWorkTypeByType(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		long workTypeID = Long.parseLong(request.getParameter("workTypeID"));
		long minLongTime = Long.parseLong(request.getParameter("minLongTime"));
		long maxLongTime = Long.parseLong(request.getParameter("maxLongTime"));

		Map<String, Object> workLogSelectMapByType = new HashMap<String, Object>();

		Map<String, Long> parameterMap = new HashMap<String, Long>();
		parameterMap.put("userID", userID);
		parameterMap.put("workTypeID", workTypeID);
		parameterMap.put("minLongTime", minLongTime);
		parameterMap.put("maxLongTime", maxLongTime);

		List<WorkLog> workLogs = DoWorkLog.selectWorkLogByTime(sqlSession,
				parameterMap);

		workLogSelectMapByType.put("workLogs", workLogs);
		return workLogSelectMapByType;

	}

	@ResponseBody
	@RequestMapping(value = "/insertWorkLog.do")
	public Map<String, Object> InsertWorkLog(HttpServletRequest request,
			HttpServletResponse response) {
		long workLogID = Long.parseLong(request.getParameter("workLogID"));
		long userID = Long.parseLong(request.getParameter("userID"));
		long workTypeID = Long.parseLong(request.getParameter("workTypeID"));
		long longTime = Long.parseLong(request.getParameter("longTime"));
		String workContent = request.getParameter("workContent");
		Map<String, Object> workLogInsertMap = new HashMap<String, Object>();

		WorkLog workLog = new WorkLog(workLogID, userID, workTypeID, longTime,
				workContent);

		int i = DoWorkLog.insertWorkLog(sqlSession, workLog);
		if (i == 1)
			workLogInsertMap.put("isSuccess", true);
		else
			workLogInsertMap.put("isSuccess", false);

		return workLogInsertMap;

	}

	@ResponseBody
	@RequestMapping(value = "/updateWorkLog.do")
	public Map<String, Object> UpdateWorkLog(HttpServletRequest request,
			HttpServletResponse response) {

		long workLogID = Long.parseLong(request.getParameter("workLogID"));
		long userID = Long.parseLong(request.getParameter("userID"));
		long workTypeID = Long.parseLong(request.getParameter("workTypeID"));
		long longTime = Long.parseLong(request.getParameter("longTime"));
		String workContent = request.getParameter("workContent");
		Map<String, Object> workLogUpdateMap = new HashMap<String, Object>();

		WorkLog workLog = new WorkLog(workLogID, userID, workTypeID, longTime,
				workContent);

		int i = DoWorkLog.updateWorkLog(sqlSession, workLog);
		if (i == 1)
			workLogUpdateMap.put("isSuccess", true);
		else
			workLogUpdateMap.put("isSuccess", false);

		return workLogUpdateMap;

	}

	@ResponseBody
	@RequestMapping(value = "/deleteWorkLog.do")
	public Map<String, Object> DeleteWorkLog(HttpServletRequest request,
			HttpServletResponse response) {

		long workLogID = Long.parseLong(request.getParameter("workLogID"));

		Map<String, Object> workLogDeleteMap = new HashMap<String, Object>();
		int i = DoWorkLog.deleteWorkLog(sqlSession, workLogID);

		if (i == 1)
			workLogDeleteMap.put("isSuccess", true);
		else
			workLogDeleteMap.put("isSuccess", false);

		return workLogDeleteMap;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteWorkLogByType.do")
	public Map<String, Object> DeleteWorkLogByType(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		long workTypeID = Long.parseLong(request.getParameter("workTypeID"));
		Map<String, Long> parameterMap = new HashMap<String, Long>();
		parameterMap.put("userID", userID);
		parameterMap.put("workTypeID", workTypeID);

		Map<String, Object> workLogDeleteMap = new HashMap<String, Object>();
		int i = DoWorkLog.deleteworkLogByType(sqlSession, parameterMap);

		if (i == 1)
			workLogDeleteMap.put("isSuccess", true);
		else
			workLogDeleteMap.put("isSuccess", false);

		return workLogDeleteMap;
	}

}
