package com.dao.impl;
import java.sql.*;
import com.mysql.jdbc.Driver;
//jdbc工具类
public class jdbcUtil {
	private static String driver="com.mysql.jdbc.Driver";
	// mysql8.0:jdbc:mysql://127.0.0.1:3306/xsh?serverTimezone=GMT
	private static String url="jdbc:mysql://127.0.0.1:3306/xsh";
	private static String user="root";
	private static String pwd="root";
	private static Connection con=null;
	//开连接
	public static Connection getConn(){
		try{
			if(con==null){
				Class.forName(driver);
				con=DriverManager.getConnection(url, user, pwd);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	//关连接
	public static void closeConn(){
		try{
			if(con!=null){
				con.close();
				con=null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
