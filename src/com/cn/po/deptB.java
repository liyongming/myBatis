package com.cn.po;

import java.util.List;

/**
 *@dept.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月11日
 *@下午5:37:54
 *@TODO
 */

public class deptB {
	private Integer deptno;//部门编号
	private String dname;//部门名字
	private String loc;//部门位置
	private List<emp> emp;
	
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	public List<emp> getEmp() {
		return emp;
	}
	public void setEmp(List<emp> emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "deptB [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", emp=" + emp + "]";
	}
	
	
}
