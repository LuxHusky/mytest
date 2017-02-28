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

import com.mws.domain.WorkType;
import com.mws.domapper.DoWorkType;

@Controller
public class WorkTypeController {

	SqlSession sqlSession = InitSqlSession
			.getSqlSession();

	/**
	 * worktype表select操作
	 * 
	 * @return
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value = "/selectWorkType.do")
	public Map<String, Object> selectWorkType(HttpServletRequest request,
			HttpServletResponse response) {

		long workTypeID = Long.parseLong(request.getParameter("workTypeID"));
		Map<String, Object> workTypeSelectMap = new HashMap<String, Object>();

		if (Long.toString(workTypeID).isEmpty()) {

			List<WorkType> workTypes = DoWorkType.selectWorkType(sqlSession);
			workTypeSelectMap.put("workType", workTypes);

		} else {

			WorkType workType = DoWorkType.selectWorkTypeByID(sqlSession,
					workTypeID);
			workTypeSelectMap.put("workType", workType);

		}

		return workTypeSelectMap;

	}

	/**
	 * worktype表的insert操作
	 * 
	 * @return
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value = "/insertWorkType.do")
	public Map<String, Object> InsertWorkType(HttpServletRequest request,
			HttpServletResponse response) {

		long workTypeID = Long.parseLong(request.getParameter("workTypeID"));
		String workTypeName = request.getParameter("workTypeName");
		Map<String, Object> workTypeInsertMap = new HashMap<String, Object>();

		WorkType workType = new WorkType(workTypeID, workTypeName);
		int i = DoWorkType.insertWorkType(sqlSession, workType);
		if (i == 1)
			workTypeInsertMap.put("isSuccess", true);
		else
			workTypeInsertMap.put("isSuccess", false);

		return workTypeInsertMap;

	}

	/**
	 * wortype表的update操作
	 * 
	 * @return
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value = "updateWorkType.do")
	public Map<String, Object> UpdateWorkType(HttpServletRequest request,
			HttpServletResponse response) {
		long workTypeID = Long.parseLong(request.getParameter("workTypeID"));
		String workTypeName = request.getParameter("workTypeName");
		Map<String, Object> workTypeUpdateMap = new HashMap<String, Object>();

		WorkType workType = new WorkType(workTypeID, workTypeName);
		int i = DoWorkType.updateWorkType(sqlSession, workType);

		if (i == 1)
			workTypeUpdateMap.put("isSuccess", true);
		else
			workTypeUpdateMap.put("isSuccess", false);

		return workTypeUpdateMap;

	}

	/**
	 * worktype表的delete操作
	 * 
	 * @return
	 * 
	 * */
	@ResponseBody
	@RequestMapping(value = "/deleteWorkType.do")
	public Map<String, Object> DeleteWorkType(HttpServletRequest request,
			HttpServletResponse response) {
		long workTypeID = Long.parseLong(request.getParameter("workTypeID"));
		Map<String, Object> workTypeDeleteMap = new HashMap<String, Object>();

		int i = DoWorkType.deleteWorkType(sqlSession, workTypeID);
		if (i == 1)
			workTypeDeleteMap.put("isSuccess", true);
		else
			workTypeDeleteMap.put("isSuccess", false);

		return workTypeDeleteMap;

	}
	
	
}
