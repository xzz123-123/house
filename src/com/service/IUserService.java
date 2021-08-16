package com.service;

import java.util.List;

import com.entity.dept;

public interface IUserService {
	List<dept> selectAll();//查全部
	int insertStu(dept d);//添加
}
