package com.mws.domapper;

import org.apache.ibatis.session.SqlSession;

import com.mws.domain.ChoiceQuestion;

public class DoChoiceQuestion {
	//获取题目
	public static ChoiceQuestion doGetChoiceQuestion(SqlSession sqlSession,int num){
	/*	DoChoiceQuestion.fnum=getChoiceQuestionNum(sqlSession);
		if(num<=fnum&&num>=1){
			switch (Integer.parseInt(flag)) {
		case 0:
			++DoChoiceQuestion.num;
			return getChoiceQuestion(sqlSession,DoChoiceQuestion.num);
		case 1:
			--DoChoiceQuestion.num;
			return getChoiceQuestion(sqlSession,DoChoiceQuestion.num);
		default:
			break;
		}
	}*/
		
		return getChoiceQuestion(sqlSession,num);
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
	
}
