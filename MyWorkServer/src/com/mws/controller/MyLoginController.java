package com.mws.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mws.domain.MyUser;
import com.mws.domain.User;
import com.mws.domapper.DoChoiceQuestion;
import com.mws.domapper.DoMyUser;
import com.mws.domapper.DoUser;

@Controller
public class MyLoginController {
	SqlSession sqlSession = InitSqlSession.getSqlSession();
	@ResponseBody
	@RequestMapping(value = "/myUserLogin.do")
	public Map<String, Object> UserLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String account = request.getParameter("username");
		String password = request.getParameter("password");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		MyUser user = DoMyUser.selectUserByAccount(sqlSession,account);
		int total = DoChoiceQuestion.getChoiceQuestionNum(sqlSession);
		if(user == null){
			resultMap.put("flag", false);
			resultMap.put("Msg","用户不存在");
		}else{
			if(user.getPassword().equals(password)){
				resultMap.put("flag", true);
				resultMap.put("Msg", "登陆成功");
				resultMap.put("loginType",user.getLoginType());
				resultMap.put("userInfo", user);
				resultMap.put("total", total);
			}else{
			resultMap.put("flag", false);
			resultMap.put("Msg","密码输入错误");
			}
			
		}
		return resultMap;
		
		
		
	}
	
}
