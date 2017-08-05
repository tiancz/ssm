package com.tian.cola.dto.user;
/**
 *@author 田超哲
 *@date 2016年4月3日下午10:03:00
 *@功能:
 */
public class UserDTO {
	private String id;
	private String username;
	private String password;
	private String email;
	private String identity;
	private String grade;
	private String apply_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getApply_date() {
		return apply_date;
	}
	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}
	@Override
	public String toString() {
		return "id:"+id+" "+"username:"+username+" "+"password:"+password+
				" "+"email:"+email+" "+"identity:"+identity+" "+
				"grade:"+grade+" "+"apply_date:"+apply_date;
	}
}
