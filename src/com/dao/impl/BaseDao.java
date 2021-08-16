package com.dao.impl;

import java.sql.*;

// dao 的父类
public class BaseDao {

	protected Connection con = null ;
	
	// 初始化 
	protected void init(){
		// con = JdbcUtil.getConn();
		con = jdbcUtil.getConn();
	}
	
	// 关闭
	protected void close(){
		jdbcUtil.closeConn();
		con = null ;
	}
	
	// 统一查询 
	protected ResultSet getRs(String sql,Object... oarr) throws Exception{
		if(con != null){
			PreparedStatement stmt = con.prepareStatement(sql);
			if(oarr != null && oarr.length >0){
				for(int i=0;i<oarr.length;i++){
					if(oarr[i] instanceof Date){ // 时间特殊处理
						stmt.setDate(i+1, (Date)oarr[i]); 
					}else{
						stmt.setObject(i+1, oarr[i]); // 设置参数 ：int, String可以自动识别
					}
				}
			}
			ResultSet rs = stmt.executeQuery(); // 执行查询
			return rs;
		}else{
			return null;
		}
	}
	
	// 统一修改 ： insert update delete
	protected int getNum(String sql,Object... oarr) throws Exception{
		int num = 0;
		if( con != null){
			PreparedStatement stmt = con.prepareStatement(sql);
			if(oarr != null && oarr.length >0){
				for(int i=0;i<oarr.length;i++){
					if(oarr[i] instanceof Date){ // 时间特殊处理
						stmt.setDate(i+1, (Date)oarr[i]); 
					}else{
						stmt.setObject(i+1, oarr[i]); // 设置参数 ：int, String可以自动识别
					}
				}
			}
			num = stmt.executeUpdate(); // 执行修改
		}
		return num ;
	}
	
}
