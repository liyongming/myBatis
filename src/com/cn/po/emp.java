package com.cn.po;

import java.sql.Date;

/**
 *@emp.java
 *@
 *@myBatis
 *@author lym
 *@2017年11月11日
 *@下午3:05:15
 *@TODO
 */

public class emp {
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;//上级领导
	private Date hirdate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Date getHirdate() {
		return hirdate;
	}
	public void setHirdate(Date hirdate) {
		this.hirdate = hirdate;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public Integer getComm() {
		return comm;
	}
	public void setComm(Integer comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hirdate=" + hirdate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
	
	
}
