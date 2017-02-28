package com.mws.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mws.domain.MyUser;
import com.mws.domapper.DoMyUser;
import com.mws.domapper.DoRegisterUser;

@Controller
public class RegisterController {
	SqlSession sqlSession = InitSqlSession.getSqlSession();
	@ResponseBody
	@RequestMapping(value = "/myUserRegister.do")
	public Map<String, Object> UserRegister(HttpServletRequest request,
			HttpServletResponse response){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String id=request.getParameter("id");
			String department=request.getParameter("department");
			Map<String, Object> resultMap = new HashMap<String, Object>();
			MyUser myuser=DoMyUser.selectUserByID(sqlSession, Integer.parseInt(id));
			if(!(myuser==null)){
				resultMap.put("Msg","工号已经存在请正确输入");
				resultMap.put("flag",false);
			}else{
				MyUser newuser = new MyUser(username, password, name, Integer.parseInt(id),"考生",0);
				DoRegisterUser.registUser(sqlSession, newuser);
				resultMap.put("Msg","恭喜注册成功,前往登录界面");
				resultMap.put("flag", true);
			}
				return resultMap;
		
	}

}
