package com.service;

import java.util.List;

import com.entity.dept;

public interface IUserService {
	List<dept> selectAll();//��ȫ��
	int insertStu(dept d);//���
}
