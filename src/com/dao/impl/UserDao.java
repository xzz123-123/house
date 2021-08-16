package com.dao.impl;
import java.util.*;
import java.sql.*;

import com.dao.IUserDao;
import com.entity.*;
public class UserDao extends BaseDao implements IUserDao {
	//查全部
		public List<dept> selectAll() {
			init();//初始化
			List<dept> list=new ArrayList();//因为返回list
			try{
				String sql=" SELECT * FROM dept ";
				ResultSet rs=getRs(sql);
				//封装数据
				while(rs.next()){
					dept d=new dept();
					d.setDEPTNO(rs.getInt("dEPTNO"));
					d.setDNAME(rs.getString("dNAME"));
					d.setLOC(rs.getString("lOC"));
					list.add(d);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			close();//关闭
			return list;
		}
		//添加
		public int insertStu(dept d) {
			init();
			int num=0;
			try{
				String sql=" INSERT INTO dept VALUES(?,?,?) ";
				num=getNum(sql,d.getDEPTNO(),d.getDNAME(),d.getLOC());
			}catch(Exception e){
				e.printStackTrace();
			}
			close();
			return num;
		}
}
