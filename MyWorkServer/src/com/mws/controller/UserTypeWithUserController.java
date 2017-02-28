package com.mws.controller;

import java.util.ArrayList;
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
import com.mws.domain.WorkType;
import com.mws.domapper.DoUserType;
import com.mws.domapper.DoWorkType;

@Controller
public class UserTypeWithUserController {

	private static Logger log = Logger
			.getLogger(UserTypeWithUserController.class);

	SqlSession sqlSession = InitSqlSession.getSqlSession();

	@ResponseBody
	@RequestMapping(value = "/selectTypeByUser.do")
	public List<WorkType> SelectTypeByUser(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));

		List<UserType> userTypes = null;

		userTypes = DoUserType.selectUserType(sqlSession, userID);

		List<WorkType> workTypes = new ArrayList<WorkType>();

		for (int i = 0; i < userTypes.size(); i++) {

			UserType userType = userTypes.get(i);
			long workTypeID = userType.getWorkTypeID();

			WorkType workType = DoWorkType.selectWorkTypeByID(sqlSession,
					workTypeID);

			workTypes.add(workType);
		}
		return workTypes;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteUserTypeByUser.do")
	public Map<String, Object> DeleteUserTypeByUser(HttpServletRequest request,
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

		sqlSession.clearCache();

		return userTypeDeleteMap;

	}

	@ResponseBody
	@RequestMapping(value = "/insertUserTypeByUser.do")
	public Map<String, Object> InsertUserTypeByUser(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		long workTypeID = Long.parseLong(request.getParameter("workTypeID"));
		String workTypeName = request.getParameter("workTypeName");
		Map<String, Object> resultMap = new HashMap<String, Object>();

		WorkType workType = DoWorkType.selectWorkTypeByName(sqlSession,
				workTypeName);
		if (workType != null) {

			long exist_workTypeID = workType.getWorkTypeID();

			UserType check_userType = new UserType(userID, exist_workTypeID);
			UserType exist_userType = DoUserType.checkUserType(sqlSession,
					check_userType);

			if (exist_userType == null) {

				UserType userType = new UserType(userID, exist_workTypeID);
				int i = DoUserType.insertUserType(sqlSession, userType);
				if (i == 1) {
					resultMap.put("isSuccess", 1);
				} else {
					resultMap.put("isSuccess", -1);
				}

			} else {
				// userType已存在
				resultMap.put("isSuccess", 0);

			}
			return resultMap;

		} else {
			WorkType new_workType = new WorkType(workTypeID, workTypeName);
			int i = DoWorkType.insertWorkType(sqlSession, new_workType);
			if (i == 1) {
				UserType new_userType = new UserType(userID, workTypeID);
				int j = DoUserType.insertUserType(sqlSession, new_userType);
				if (j == 1) {
					resultMap.put("isSuccess", 1);
				} else {
					resultMap.put("isSuccess", -1);
				}
			} else {
				resultMap.put("isSuccess", -1);
			}

		}
		return resultMap;

	}
}
