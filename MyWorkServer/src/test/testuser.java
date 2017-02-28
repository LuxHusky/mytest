package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import com.mws.controller.InitSqlSession;
import com.mws.domain.MyUser;

import com.mws.domapper.DoMyUser;
import com.mws.domapper.DoRegisterUser;


public class testuser {
	@Test
	public void testgetuser(){
		SqlSession sqlSession = InitSqlSession.getSqlSession();
		MyUser user = DoMyUser.selectUserByName(sqlSession, "fdf");
		System.out.println(user.toString() );
	}
	@Test
	public void testSelectAlluser(){
		SqlSession sqlSession = InitSqlSession.getSqlSession();
		List<MyUser>list=DoMyUser.selectAll(sqlSession);
		int i=0;
		while(!list.isEmpty()){
			System.out.println(list.get(i));
			i++;
		}
	}
	@Test
	public void testGetuserByID(){
		SqlSession sqlSession = InitSqlSession.getSqlSession();
		MyUser myuser=DoMyUser.selectUserByID(sqlSession, 23);
		System.out.println(myuser);
	}
	@Test
	public void testInsertUser(){
		SqlSession sqlSession = InitSqlSession.getSqlSession();
		MyUser myuser =new MyUser("account1", "password1", "name1",323,"loginType1", 111);
		DoRegisterUser.registUser(sqlSession, myuser);
	}
	
}
