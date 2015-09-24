package com.xulf.framework.jdbc.common;

import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class DBUtils {
	private static Properties properties=new Properties();
	private static ResourceBundle bundle = ResourceBundle.getBundle("jdbc-mysql");
	private static String driver=bundle.getString("jdbc.driver");
	private static String url = bundle.getString("jdbc.url");
	private static String username= bundle.getString("jdbc.username");
	private static String pwd = bundle.getString("jdbc.password");

	//加载配置文件， 初始化数据库连接信息
	static{
		try{
			//加载数据库驱动类
			Class.forName(driver);
		}catch(Exception e){ //如果数据库加载失败， 抛出运行时异常
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 *  返回数据库连接
	 * @return 如果成功获取连接， 返回 数据库连接
	 * 		如果未能获得连接， 抛出异常
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, pwd);
	}

	/**关闭连接*/
	public static void closeConnection(Connection con){
		if(con != null){
			try{
				con.close();
			}catch(SQLException e){
				System.out.println("关闭连接时发生异常");
				e.printStackTrace();
			}
		}
	}
	
	/**关闭所有数据库资源*/
	public static void closeAll(Connection con, Statement stmt, ResultSet rs){
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
