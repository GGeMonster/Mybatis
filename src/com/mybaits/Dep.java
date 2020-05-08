package com.mybaits;

import java.io.Serializable;
import java.util.List;

public class Dep   implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Integer  id;
	private  String deptName;
	private  List<Employee> employees;
	

	public Dep() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dep(Integer id, String deptName) {
		super();
		this.id = id;
		this.deptName = deptName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Dep [id=" + id + ", deptName=" + deptName + ", employees=" + employees + "]";
	}
	
	
	
	

}
