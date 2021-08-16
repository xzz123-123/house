package com.dao;

import java.util.List;

import com.entity.dept;
import com.entity.dept;

public interface IUserDao {
	List<dept> selectAll();//查询全部
	int insertStu(dept d);//添加
}
