package com.mws.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mws.domain.User;
import com.mws.domapper.DoUser;

@Controller
public class LoginController {

	private long userID;
	private String userName, userPassWord;

	SqlSession sqlSession = InitSqlSession.getSqlSession();

	@ResponseBody
	@RequestMapping(value = "/userLogin.do")
	public Map<String, Object> UserLogin(HttpServletRequest request,
			HttpServletResponse response) {

		int userSysID = Integer.parseInt(request.getParameter("userSysID"));
		String userPassWord_login = request.getParameter("userPassWord");

		Map<String, Object> resultMap = new HashMap<String, Object>();

		User user = DoUser.selectUserBySysID(sqlSession, userSysID);
		if (user == null) {
			resultMap.put("flag", false);
			resultMap.put("userID", 0l);
			resultMap.put("userName", "");

			return resultMap;
		}
		userID = user.getUserID();
		userName = user.getUserName();
		userPassWord = user.getUserPassWord();

		boolean flag = userPassWord_login.equals(userPassWord);
		if (flag) {

			resultMap.put("flag", flag);
			resultMap.put("userID", userID);
			resultMap.put("userName", userName);

		} else {
			resultMap.put("flag", flag);
			resultMap.put("userID", 0l);
			resultMap.put("userName", "");

		}
		return resultMap;

	}
}
