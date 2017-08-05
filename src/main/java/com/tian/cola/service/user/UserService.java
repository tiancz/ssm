package com.tian.cola.service.user;

import java.util.List;

import com.tian.cola.dto.user.UserDTO;

/**
 *@author 田超哲
 *@date 2016年4月3日下午10:05:22
 *@功能:
 */
public interface UserService {
	public List<UserDTO> getUsers();
	
	public UserDTO getUserNameById(String id);
}
