package com.tian.cola.dao.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tian.cola.dao.BaseDAO;
import com.tian.cola.dao.user.UserDAO;
import com.tian.cola.dto.user.UserDTO;

/**
 *@author 田超哲
 *@date 2016年4月3日下午10:08:35
 *@功能:
 */
@Repository("userDao")
public class UserDAOImpl extends BaseDAO implements UserDAO {
	
	public List<UserDTO> getUsers(){
		List<UserDTO> users = new ArrayList<>();
		users = CDUtil().selectList("getUser");
		return users;
	}
	
	public UserDTO getUserNameById(String sql,String id){
		UserDTO user = new UserDTO();
		user = CDUtil().selectOne("getUserNameById",id);
		return user;
	}
}
