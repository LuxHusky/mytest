package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mws.controller.InitSqlSession;
import com.mws.domain.MyUser;
import com.mws.domapper.Doadmin;

public class testadmin {
	@Test
	public void testadmin(){
		SqlSession sqlSession = InitSqlSession.getSqlSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id","");
		map.put("department","");
		map.put("name","");
		
		List<MyUser> myuser =Doadmin.uncertainQuery(sqlSession, map);
		for (MyUser myUser2 : myuser) {
			System.out.println(myUser2);
		}
	}
}
