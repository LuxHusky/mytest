package com.mws.domapper;

import org.apache.ibatis.session.SqlSession;

import com.mws.domain.ChoiceQuestion;
import com.mws.domain.MyUser;

public class DoChoiceQuestion {
	//获取题目
	public static ChoiceQuestion doGetChoiceQuestion(SqlSession sqlSession,int num){
		
		return getChoiceQuestion(sqlSession,num);
	}
	
	//判断答案是否正确
	public static void makeSorce(String answer,int id,SqlSession sqlSession,int userid){
		ChoiceQuestion cq=getChoiceQuestion(sqlSession,id-1);
		MyUser myUser = DoMyUser.selectUserByID(sqlSession, userid);
		if(cq.getRightAnswer().equals(answer)){
			myUser.setUser_sorce(myUser.getUser_sorce()+1);
			DoMyUser.updateSorce(sqlSession, myUser);
		}
	
	}
		
	
	public static ChoiceQuestion getChoiceQuestion(SqlSession sqlSession,int num){
		String strMapperID ="com.mws.mapping.choiceMapper.getchoice";
		ChoiceQuestion choiceQuestion=sqlSession.selectOne(strMapperID, num);
		return choiceQuestion;
	}
	//获取表中共有多少条数据
	public static int getChoiceQuestionNum(SqlSession sqlSession){
		String strMapperID ="com.mws.mapping.choiceMapper.getchoicenum";
		int num=sqlSession.selectOne(strMapperID);
		return num;
		
	}
	public static int insertChoiceQuestion(SqlSession sqlSession,ChoiceQuestion choiceQuestion){
		String strMapperID="com.mws.mapping.choiceMapper.insertChoiceQuestion";
		int num = sqlSession.insert(strMapperID, choiceQuestion);
		sqlSession.commit();
		return num;
		
	}
	
}
