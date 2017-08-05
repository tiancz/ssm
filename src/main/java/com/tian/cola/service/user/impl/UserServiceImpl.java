package com.tian.cola.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tian.cola.dao.user.UserDAO;
import com.tian.cola.dto.user.UserDTO;
import com.tian.cola.service.user.UserService;

/**
 *@author 田超哲
 *@date 2016年4月3日下午10:06:05
 *@功能:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("userDao")
	private UserDAO userDao;
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public List<UserDTO> getUsers(){
		return userDao.getUsers();
	}
	

	public UserDTO getUserNameById(String id){
		UserDTO user = new UserDTO();
		user = userDao.getUserNameById("getUserNameById",id);
		return user;
	}
}
