package com.mws.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mws.domain.ChoiceQuestion;
import com.mws.domapper.DoChoiceQuestion;

@Controller
public class ChoiceQuestionController {
	SqlSession sqlSession = InitSqlSession.getSqlSession();
	@ResponseBody
	@RequestMapping(value = "/getfChoice.do")public Map<String, Object> fChoice(HttpServletRequest request,
			HttpServletResponse response){
				
		int flag=Integer.parseInt(request.getParameter("flag"));
		ChoiceQuestion question=DoChoiceQuestion.doGetChoiceQuestion(sqlSession, flag);		
		int total = DoChoiceQuestion.getChoiceQuestionNum(sqlSession);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		if(question == null){
			resultMap.put("flag",false);
			resultMap.put("Msg","错误操作");
		}else{
			resultMap.put("flag",true);
			resultMap.put("question", question);
			resultMap.put("total", total);
		}
		return resultMap;
		
	}
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/getChoice.do")
	public Map<String, Object> Choice(HttpServletRequest request,
			HttpServletResponse response){
		int flag=Integer.parseInt(request.getParameter("flag"));
		String answer = request.getParameter("answer");
		int userid = Integer.parseInt(request.getParameter("userid"));
		ChoiceQuestion question=DoChoiceQuestion.doGetChoiceQuestion(sqlSession, flag);		
		int total = DoChoiceQuestion.getChoiceQuestionNum(sqlSession);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		if(question == null){
			resultMap.put("flag",false);
			resultMap.put("Msg","错误操作");
		}else{
			DoChoiceQuestion.makeSorce(answer, flag, sqlSession, userid);	
			resultMap.put("flag",true);
			resultMap.put("question", question);
			resultMap.put("total", total);
		}
		return resultMap;
		
	}

	@ResponseBody
	@RequestMapping(value = "/upChoice.do")
	public Map<String, Object> upChoice(HttpServletRequest request,
			HttpServletResponse response){
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setSizeThreshold(1024);
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		Map<String, byte[]> fileMap = new HashMap<String, byte[]>();
		Map<String, String> textMap = new HashMap<String, String>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		InputStream input=null;
		List<FileItem> fileItem;
		boolean b1 = false;
		String id = "";
		try{
			fileItem = servletFileUpload.parseRequest(request);
			id = request.getParameter("id");
			List<ChoiceQuestion> items = new ArrayList<ChoiceQuestion>();
			for (int i = 0; i < fileItem.size(); i++) {
				FileItem item = (FileItem) fileItem.get(i);
				// 判断是普通表单还是文件上传于， true是普通表单
				if (!item.isFormField() && item.getName() != null && !"".equals(item.getName())) {
					input=item.getInputStream();
					
					
					
					Workbook workbook = WorkbookFactory
								.create(input);
					Sheet sheet = workbook.getSheetAt(0);
						
					if (sheet != null) {
							for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
								System.out.println(j);
								Row row = sheet.getRow(j);
								if(row ==null){
									continue;
								}
								Map<String, Object> map = new HashMap<String, Object>();
								if(j>0){
										
									ChoiceQuestion item2 = new ChoiceQuestion();
										for (int x = 0; x < row.getPhysicalNumberOfCells(); x++) {
											Cell cell = row.getCell(x);
											String cellStr ="";
											if(cell !=null){
												cellStr = cell.toString();
											}
											switch (x) {
												case 0:
													item2.setQid((int) Double.parseDouble(cellStr));
													break;
												case 1:
													item2.setQcontext(cellStr);
													break;
												case 2:
													item2.setAnswerA(cellStr);
													break;
												case 3:
													item2.setAnswerB(cellStr);
													break;
												case 4:
													item2.setAnswerC(cellStr);
													break;
												case 5:
													item2.setAnswerD(cellStr);
													break;
												case 6:
													item2.setRightAnswer(cellStr);
													break;
											}
											
										}
										items.add(item2);
										
								}		
							
						}
					
					}

				}
				
			}
		
			int num = 0;
			for (ChoiceQuestion item : items) {
				ChoiceQuestion cq=DoChoiceQuestion.getChoiceQuestion(sqlSession,item.getQid());
				if(cq==null){
					 num=DoChoiceQuestion.insertChoiceQuestion(sqlSession,item);
				}
				
			}
		
			if(num == 0){
				resultMap.put("flag",false);
				resultMap.put("Msg","导入失败");
			}else if (num == items.size()) {
				resultMap.put("flag",true);
				resultMap.put("Msg","导入成功");
			}else {
				resultMap.put("flag",true);
				resultMap.put("Msg","部分导入成功");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
				return resultMap ;
				
		}
	
}
