package com.tian.cola.dao.user;

import java.util.List;

import com.tian.cola.dto.user.UserDTO;

/**
 *@author 田超哲
 *@date 2016年4月3日下午10:08:35
 *@功能:
 */
public interface UserDAO {
	public List<UserDTO> getUsers();
	public UserDTO getUserNameById(String sql,String id);
}
