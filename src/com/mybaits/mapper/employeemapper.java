package com.mybaits.mapper;

import java.sql.Array;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import com.mybaits.Employee;


public interface employeemapper {
	
	public List<Employee>  getempAll();
	
	public  Employee  getempbyId(Integer id);
	
	
	public  Employee  getempbyIdandname(@Param("id")Integer id,@Param("lastname")String lastName);
	
	public void insertemp(Employee employee);
	
	public void updateemp(Employee employee);
	
	public boolean deletetemp(@Param("id")Integer id);
	
	@MapKey("lastName")
	public  Map<String, Employee>  getempbylastNamelike(String lastname);
	
	
	public  List<Employee>  getempbylastNamelikelist(String lastname);
	
	
	public  Employee getemployeebyid(Integer id);
	
	public  Employee getemployeeAssociationbyid(Integer id);
	
	public  Employee getemployeeAssociationFbbyid(Integer id);
	
	public  Employee getemployeebydeptid(Integer id);
	
	
	public  List<Employee> getemplodeptid();
	
	//if/where
	public  List<Employee>  getemployee(Employee employee);
	
	//strim
	public  List<Employee>  getemployeetrim(Employee employee);
	
	//set
	public void updateSetemp(Employee employee);
	
	//choose
	public  List<Employee>  getemployeechoose(Employee employee);
	
	//foreach
	public  List<Employee>  getemployeeforeach(@Param("arrs")List arrs);
	
	//批量保存
	public void addEmployees(@Param("emps")List<Employee> emps);
	//批量保存2
	public void addEmployees2(@Param("emps")List<Employee> emps);
}
