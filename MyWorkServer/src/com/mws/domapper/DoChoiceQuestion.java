package com.mws.domapper;

import org.apache.ibatis.session.SqlSession;

import com.mws.domain.ChoiceQuestion;

public class DoChoiceQuestion {
	private static int num=1;
	public static ChoiceQuestion doGetChoiceQuestion(SqlSession sqlSession,String flag){
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
		
		return getChoiceQuestion(sqlSession,DoChoiceQuestion.num);
	}
	public static ChoiceQuestion getChoiceQuestion(SqlSession sqlSession,int num){
		String strMapperID ="com.mws.mapping.choiceMapper.getchoice";
		ChoiceQuestion choiceQuestion=sqlSession.selectOne(strMapperID, num);
		return choiceQuestion;
	}
}
