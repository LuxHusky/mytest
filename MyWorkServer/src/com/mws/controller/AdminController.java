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

import com.mws.domain.MyUser;
import com.mws.domapper.Doadmin;

@Controller
public class AdminController {
	SqlSession sqlSession = InitSqlSession.getSqlSession();

	@ResponseBody
	@RequestMapping(value = "/admin.do")
	public Map<String, Object> admin(HttpServletRequest request,
			HttpServletResponse response) {
		String myusername = request.getParameter("myusername");
		String myuserDepartment = request.getParameter("myuserDepartment");
		String myuserId = request.getParameter("myuserId");
		Map<String, Object> reqMap = new HashMap<String, Object>();
		Map<String,Object> repMap = new HashMap<String, Object>();
		reqMap.put("name", myusername);
		reqMap.put("department", myuserDepartment);
		reqMap.put("id", myuserId);
		List<MyUser> userlist = Doadmin.uncertainQuery(sqlSession,
				(HashMap<String, Object>) reqMap);
		if(userlist.size()<0){
			repMap.put("flag",false);
			repMap.put("Msg", "没有找到符合条件的对象");
		}
		//找到结果
		return null;

	}
}
