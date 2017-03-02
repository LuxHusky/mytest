package com.mws.domapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mws.domain.MyUser;

public class Doadmin {
	public static List<MyUser> uncertainQuery(SqlSession sqlSession,HashMap<String, Object> map){
		String strID ="com.mws.mapping.uncertainQueryMapper.uncertainquery";
		List<MyUser> listuser=sqlSession.selectList(strID, map);
		sqlSession.commit();
		return listuser;	
	}
}
