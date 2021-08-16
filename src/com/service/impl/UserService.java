package com.service.impl;
import java.util.*;

import com.entity.*;
import com.service.IUserService;
import com.dao.*;
import com.dao.impl.*;
public class UserService implements IUserService {
	private IUserDao userDao=new UserDao();
	//查全部
	public List<dept> selectAll() {
		return userDao.selectAll();
	}
	//添加
	public int insertStu(dept d) {
		return userDao.insertStu(d);
	}
	
}
