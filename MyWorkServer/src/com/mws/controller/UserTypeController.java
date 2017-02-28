package com.mws.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mws.domain.UserType;
import com.mws.domapper.DoUserType;

@Controller
public class UserTypeController {

	private static Logger log = Logger.getLogger(UserTypeController.class);

	SqlSession sqlSession = InitSqlSession.getSqlSession();

	@ResponseBody
	@RequestMapping(value = "/insertUserType.do")
	public Map<String, Object> InsertUserType(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		long workTypeID = Long.parseLong(request.getParameter("workTypeID"));

		Map<String, Object> userTypeInsertMap = new HashMap<String, Object>();
		UserType userType = new UserType(userID, workTypeID);
		int i = DoUserType.insertUserType(sqlSession, userType);

		if (i == 1)
			userTypeInsertMap.put("isSuccess", true);
		else
			userTypeInsertMap.put("isSuccess", false);
		return userTypeInsertMap;

	}

	@ResponseBody
	@RequestMapping(value = "/deleteUserType.do")
	public Map<String, Object> DeleteUserType(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		long workTypeID = Long.parseLong(request.getParameter("workTypeID"));
		

		Map<String, Object> userTypeDeleteMap = new HashMap<String, Object>();
		UserType userType = new UserType(userID, workTypeID);

		int i = DoUserType.deleteUserType(sqlSession, userType);
		
		if (i == 1)
			userTypeDeleteMap.put("isSuccess", true);
		else
			userTypeDeleteMap.put("isSuccess", false);

		return userTypeDeleteMap;

	}

	@ResponseBody
	@RequestMapping(value = "/selectUserType.do")
	public Map<String, Object> SelectUserType(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));

		Map<String, Object> userTypeSelectMap = new HashMap<String, Object>();

		List<UserType> userTypes = DoUserType
				.selectUserType(sqlSession, userID);
		userTypeSelectMap.put("userTypes", userTypes);

		return userTypeSelectMap;
	}

	@ResponseBody
	@RequestMapping(value = "/updateUserType.do")
	public Map<String, Object> UpdateUserType(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		long oldWorkTypeID = Long.parseLong(request
				.getParameter("oldWorkTypeID"));
		long newWorkTypeID = Long.parseLong(request
				.getParameter("newWorkTypeID"));

		Map<String, Object> userTypeUpdateMap = new HashMap<String, Object>();
		Map<String, Long> parameterMap = new HashMap<String, Long>();

		parameterMap.put("userID", userID);
		parameterMap.put("oldWorkTypeID", oldWorkTypeID);
		parameterMap.put("newWorkTypeID", newWorkTypeID);
		int i = DoUserType.updateUserType(sqlSession, parameterMap);

		if (i == 1)
			userTypeUpdateMap.put("isSuccess", true);

		else
			userTypeUpdateMap.put("isSuccess", false);

		return userTypeUpdateMap;

	}
}
