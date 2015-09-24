package com.xulf.framework.mybatis.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
	/**
	 * 加载主配置文件， 获取sqlSession
	 * @return
	 * @throws IOException
	 */
	public static SqlSession openSqlSession() throws IOException{
		Reader reader = Resources.getResourceAsReader("sqlMapperConfigure.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = builder.build(reader);
		return sf.openSession();
	}

	public static void closeSqlSession(SqlSession sqlSession){
		if(sqlSession == null){
			return;
		}

		try{
			sqlSession.close();
		}catch (Exception e){}
	}
}
