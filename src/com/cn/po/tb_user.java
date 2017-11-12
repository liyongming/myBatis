package com.cn.po;

import java.io.Serializable;
import java.util.List;

/**
 *@tb_user.java
 *@用户表
 *@myBatis
 *@author lym
 *@2017年11月12日
 *@下午3:45:40
 *@TODO
 */

public class tb_user implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer user_id;
	private String username;
	private String loginname;
	private String password;
	private String phone;
	private String address;
	
	private List<tb_order> orders;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<tb_order> getOrders() {
		return orders;
	}
	public void setOrders(List<tb_order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "tb_user [user_id=" + user_id + ", username=" + username + ", loginname=" + loginname + ", password="
				+ password + ", phone=" + phone + ", address=" + address + ", orders=" + orders + "]";
	}

	
	
	
}
