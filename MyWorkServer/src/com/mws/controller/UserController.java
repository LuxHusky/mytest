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

import com.mws.domain.User;
import com.mws.domapper.DoUser;

@Controller
public class UserController {

	private static Logger log = Logger.getLogger(UserController.class);

	SqlSession sqlSession = InitSqlSession.getSqlSession();

	/**
	 * user表的insert操作
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value = "/insertUser.do")
	public Map<String, Object> InsertUser(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		int userSysID = Integer.parseInt(request.getParameter("userSysID"));
		String userName = request.getParameter("userName");
		String userPassWord = request.getParameter("userPassWord");
		
		User user = new User(userID, userSysID, userName, userPassWord);
		int i = DoUser.insertUser(sqlSession, user);

		Map<String, Object> usersInsertMap = new HashMap<String, Object>();

		if (i == 1)
			usersInsertMap.put("isSuccess", true);
		else
			usersInsertMap.put("isSuccess", false);

		return usersInsertMap;

	}

	/**
	 * user表的delete操作
	 * 
	 * */
	@ResponseBody
	@RequestMapping("/deleteUser.do")
	public Map<String, Object> deleteUser(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		int i = DoUser.deleteUser(sqlSession, userID);

		Map<String, Object> userdeleteMap = new HashMap<String, Object>();
		if (i == 1)
			userdeleteMap.put("isSuccess", true);
		else
			userdeleteMap.put("isSuccess", false);

		return userdeleteMap;

	}

	/**
	 * user表的update操作
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value = "/updateUser.do")
	public Map<String, Object> updateUser(HttpServletRequest request,
			HttpServletResponse response) {

		long userID = Long.parseLong(request.getParameter("userID"));
		int userSysID = Integer.parseInt(request.getParameter("userSysID"));
		String userName = request.getParameter("userName");
		String userPassWord = request.getParameter("userPassWord");
		User user = new User(userID, userSysID, userName, userPassWord);
		int i = DoUser.updateUser(sqlSession, user);

		Map<String, Object> userUpdateMap = new HashMap<String, Object>();
		if (i == 1)
			userUpdateMap.put("isSuccess", true);
		else
			userUpdateMap.put("isSuccess", false);
		return userUpdateMap;
	}

	/**
	 * user表的select操作
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value = "/selectUser.do")
	public Map<String, Object> SelectUser(HttpServletRequest request,
			HttpServletResponse response) {

		String userName = request.getParameter("userName");
		Map<String, Object> userSelectMap = new HashMap<String, Object>();

		if (userName == null) {

			List<User> users = DoUser.selectUser(sqlSession);
			userSelectMap.put("user", users);

		} else if (userName != null) {

			User user = DoUser.selectUserByName(sqlSession, userName);
			userSelectMap.put("user", user);

		}
		// log.info("test");
		return userSelectMap;

	}
}
