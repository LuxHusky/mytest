package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mws.controller.InitSqlSession;
import com.mws.domain.ChoiceQuestion;
import com.mws.domapper.DoChoiceQuestion;

public class testChoice {
	@Test
	public void testChoice(){
		SqlSession sqlSession = InitSqlSession.getSqlSession();
		ChoiceQuestion c=DoChoiceQuestion.getChoiceQuestion(sqlSession ,1);
		System.out.println(c.toString());
	}
	@Test
	public void testGetchocieNum(){
		SqlSession sqlSession = InitSqlSession.getSqlSession();
		int num = DoChoiceQuestion.getChoiceQuestionNum(sqlSession);
		System.out.println(num);
	}
	@Test
	public void testinsert(){
		SqlSession sqlSession = InitSqlSession.getSqlSession();
		ChoiceQuestion choiceQuestion = new ChoiceQuestion(6, "q", "A","B", "C", "D", "right");
		int num = DoChoiceQuestion.insertChoiceQuestion(sqlSession, choiceQuestion);
		
	}
	
}
