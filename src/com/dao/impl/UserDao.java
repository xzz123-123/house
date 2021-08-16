package com.dao.impl;
import java.util.*;
import java.sql.*;

import com.dao.IUserDao;
import com.entity.*;
public class UserDao extends BaseDao implements IUserDao {
	//��ȫ��
		public List<dept> selectAll() {
			init();//��ʼ��
			List<dept> list=new ArrayList();//��Ϊ����list
			try{
				String sql=" SELECT * FROM dept ";
				ResultSet rs=getRs(sql);
				//��װ����
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
			close();//�ر�
			return list;
		}
		//���
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
