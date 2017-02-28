package com.mws.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mws.domain.ChoiceQuestion;
import com.mws.domapper.DoChoiceQuestion;

@Controller
public class ChoiceQuestionController {
	SqlSession sqlSession = InitSqlSession.getSqlSession();
	@ResponseBody
	@RequestMapping(value = "/getChoice.do")
	public Map<String, Object> UserLogin(HttpServletRequest request,
			HttpServletResponse response){
		String flag=request.getParameter("flag");
		ChoiceQuestion question=DoChoiceQuestion.doGetChoiceQuestion(sqlSession, flag);		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(question == null){
			resultMap.put("flag",false);
			resultMap.put("Msg","系统错误");
		}else{
			resultMap.put("flag",true);
			resultMap.put("question", question);
		}
		return resultMap;
		
	}
}
