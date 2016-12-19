package com.security.model;
/**
 * @ClassName: User
 * @Description: TODO
 * @author:
 * @date: 2016年12月14日 下午2:25:08
 */
public class DbUser {
	private String username; //账户
	private String password;  //密码
	private Integer access;   //账户ID
	
	public static final Integer ACCESS_ADMIN = 1;  //admin权限
	
	public static final Integer ACCESS_USER = 2;  //user权限

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
	public Integer getAccess() {
		return access;
	}
	public void setAccess(Integer access) {
		this.access = access;
	}
}
