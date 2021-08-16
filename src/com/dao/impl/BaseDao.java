package com.dao.impl;

import java.sql.*;

// dao �ĸ���
public class BaseDao {

	protected Connection con = null ;
	
	// ��ʼ�� 
	protected void init(){
		// con = JdbcUtil.getConn();
		con = jdbcUtil.getConn();
	}
	
	// �ر�
	protected void close(){
		jdbcUtil.closeConn();
		con = null ;
	}
	
	// ͳһ��ѯ 
	protected ResultSet getRs(String sql,Object... oarr) throws Exception{
		if(con != null){
			PreparedStatement stmt = con.prepareStatement(sql);
			if(oarr != null && oarr.length >0){
				for(int i=0;i<oarr.length;i++){
					if(oarr[i] instanceof Date){ // ʱ�����⴦��
						stmt.setDate(i+1, (Date)oarr[i]); 
					}else{
						stmt.setObject(i+1, oarr[i]); // ���ò��� ��int, String�����Զ�ʶ��
					}
				}
			}
			ResultSet rs = stmt.executeQuery(); // ִ�в�ѯ
			return rs;
		}else{
			return null;
		}
	}
	
	// ͳһ�޸� �� insert update delete
	protected int getNum(String sql,Object... oarr) throws Exception{
		int num = 0;
		if( con != null){
			PreparedStatement stmt = con.prepareStatement(sql);
			if(oarr != null && oarr.length >0){
				for(int i=0;i<oarr.length;i++){
					if(oarr[i] instanceof Date){ // ʱ�����⴦��
						stmt.setDate(i+1, (Date)oarr[i]); 
					}else{
						stmt.setObject(i+1, oarr[i]); // ���ò��� ��int, String�����Զ�ʶ��
					}
				}
			}
			num = stmt.executeUpdate(); // ִ���޸�
		}
		return num ;
	}
	
}
