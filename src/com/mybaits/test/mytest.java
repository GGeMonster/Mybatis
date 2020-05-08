package com.mybaits.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybaits.Dep;
import com.mybaits.Employee;
import com.mybaits.mapper.depmapper;
import com.mybaits.mapper.employeemapper;

public class mytest {

	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
		
		SqlSession session = sqlSessionFactory.openSession(); 
		try { 
		Employee employee=session.selectOne("com.mybaits.mapper.employeemapper.getempbyId", 1); 
		System.out.println(employee);
			}
		finally 
		{  
			session.close(); 
		}
	}
    
	
	@Test
	public void test1() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
		
		SqlSession session = sqlSessionFactory.openSession(); 
		try { 
			employeemapper mapper=session.getMapper(employeemapper.class);
			Employee employee=mapper.getempbyId(1);
		
		System.out.println(employee);
			}
		finally 
		{  
			session.close(); 
		}
	}
	
	
	@Test
	public void test2() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
		
		SqlSession session = sqlSessionFactory.openSession(); 
		try { 
			employeemapper mapper=session.getMapper(employeemapper.class);
			Employee employee=mapper.getempbyIdandname(1,"tom");
		
		System.out.println(employee);
			}
		finally 
		{  
			session.close(); 
		}
	}
	
	
	@Test
	public void test3() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession(); 
		try { 
			employeemapper mapper=session.getMapper(employeemapper.class);
			//查询
//			Employee employee=mapper.getempbyIdandname(1,"tom");
			//增加
			Employee  employee = new  Employee(null,"rdss","0","rdss@com");
			mapper.insertemp(employee);
			//修改
//			Employee  employee = new  Employee(2,"jds3","2","jdsupdate@com");
//			mapper.updateemp(employee);
			//删除
//			boolean  d=mapper.deletetemp(2);
			
			session.commit();
		 // System.out.println(d);
			}
		finally 
		{  
			session.close(); 
		}
	}
	
	
	
	@Test
	public void test4() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
		
		SqlSession session = sqlSessionFactory.openSession(); 
		try { 
			employeemapper mapper=session.getMapper(employeemapper.class);
			
			//Map<String, Employee> employee=mapper.getempbylastNamelike("%j%");
			
			List<Employee> employee=mapper.getempbylastNamelikelist("%j%");
	
			session.commit();
		  System.out.println(employee);
			}
		finally 
		{  
			session.close(); 
		}
	}
	
	
	@Test
	public void test5() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
		SqlSession session = sqlSessionFactory.openSession(); 
		try { 
			//depmapper mapper= session.getMapper(depmapper.class);
			
			//Dep dep=mapper.getdepbyid(2);
	        //System.out.println(dep);
			//级联封装
//			employeemapper mapper= session.getMapper(employeemapper.class);
//			Employee employee=mapper.getemployeebyid(3);
//			System.out.println(employee);
			
			
			//association联合对象
//			employeemapper mapper2= session.getMapper(employeemapper.class);
//			Employee employee2=mapper2.getemployeeAssociationbyid(3);
//			System.out.println(employee2);
			
			
			//association分步查询
//			employeemapper mapper3= session.getMapper(employeemapper.class);
//			Employee employee3=mapper3.getemployeeAssociationFbbyid(3);
//			System.out.println(employee3);
			
			//association分步懒加载
			employeemapper mapper4= session.getMapper(employeemapper.class);
			Employee employee4=mapper4.getemployeeAssociationFbbyid(3);
			System.out.println(employee4.getLastName());
			
			System.out.println(employee4.getDep().getDeptName());
			
			}
		finally 
		{  
			session.close(); 
		}
	}
	
	
	@Test
	public void test6() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession(); 
		try { 
			//关联集合类型嵌套结果集
//			depmapper mapper= session.getMapper(depmapper.class);
//			Dep dep=mapper.getdepbyidlist(2);
	         
			//collection分布查询
//			depmapper mapper2= session.getMapper(depmapper.class);
//			Dep dep2=mapper2.getdepbyidFblist(2);
//			System.out.println(dep2);
//			System.out.println(dep2.getEmployees());
			
			
			//
			employeemapper mEmployeemapper=session.getMapper(employeemapper.class);
			List<Employee> employees=mEmployeemapper.getemplodeptid();
			System.out.println(employees);
			}
		finally 
		{  
			session.close(); 
		}
	}
	
	
	@Test
	public void test7() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession(); 
		try { 
			//if/where
			employeemapper mapper= session.getMapper(employeemapper.class);
//			Employee employee=new Employee(null, null, "1", null);
//			List<Employee> employees=mapper.getemployee(employee);
//	         
//			for (Employee employee2 : employees) {
//				System.out.println(employee2);
//			}
			
			//trim
//			Employee employee3=new Employee(null, null, "1", null);
//			List<Employee> employees3=mapper.getemployeetrim(employee3);
//			
//			for (Employee employee2 : employees3) {
//				System.out.println(employee2);
//			}
			
			//choose
//			Employee employee4=new Employee(null, null, null, null);
//			List<Employee> employees4=mapper.getemployeechoose(employee4);
//			
//			for (Employee employee : employees4) {
//				System.out.println(employee);
//			}
			
			//foreach
            List<Employee> employees5=mapper.getemployeeforeach(Arrays.asList(1,2,3));
			
			for (Employee emp5 : employees5) {
				System.out.println(emp5);
			}
			
			
			}
		finally 
		{  
			session.close(); 
		}
	}
	
	
	
	@Test
	public void test8() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession(); 
		try { 
			//批量保存
			employeemapper mapper= session.getMapper(employeemapper.class);
			List<Employee> employees =new ArrayList<>();
			employees.add(new Employee(null, "jdss", "0", "jdsssss@com"));
			employees.add(new Employee(null, "Idss", "1", "Idsssss@com"));
			employees.add(new Employee(null, "Wdss", "0", "Wdsssss@com"));
			mapper.addEmployees(employees);
			//mapper.addEmployees2(employees);
			session.commit();
			
			//set/trim
//			mapper.updateSetemp(new Employee(1, "jdss", null, "jdsssss@com"));
//			session.commit();
			}
		finally 
		{  
			session.close(); 
		}
	}
	
	@Test
	public void test9() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession(); 
		try { 
			//一级缓存
			employeemapper mapper = session.getMapper(employeemapper.class);
			Employee employee = mapper.getempbyId(4);
			
			//1增删改清空缓存
//			employeemapper mapper3 = session.getMapper(employeemapper.class);
//			mapper3.insertemp(new Employee(null, "xiaohua", "1", "xiaohua@com"));
			//2手动清除
//			session.clearCache();
			//3不同session
			
			//4session相同,查询条件不同
			
			
			employeemapper mapper2 = session.getMapper(employeemapper.class);
			Employee employee2 = mapper2.getempbyId(4);
			
			System.out.println(employee==employee2);
			}finally {
				
				session.close();
			}
		}
	
	
	@Test//二级缓存
	public void test10() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession(); 
		SqlSession session2 = sqlSessionFactory.openSession();
		
		//二级缓存
		 /**
		  * 1.seting 设置开启缓存
		  * 2.namespace  开启缓存
		  * 3.POJO  序列化
		  */
		try {
			employeemapper mapper = session.getMapper(employeemapper.class);
			employeemapper mapper2 = session2.getMapper(employeemapper.class);
			
			Employee employee = mapper.getempbyId(4);
			System.out.println(employee);
			session.close();
			
			Employee employee2 = mapper2.getempbyId(4);
			System.out.println(employee2);
			session.close();
			
			
		}finally {
			
			
			}
		}
	
	
	@Test//ehcache
	public void test11() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession(); 
		SqlSession session2 = sqlSessionFactory.openSession();
		
		try {
			depmapper mapper = session.getMapper(depmapper.class);
			Dep dep = mapper.getdepbyid(2);
			System.out.println(dep);
			session.close();
			
			
			depmapper mapper2 = session2.getMapper(depmapper.class);
			Dep dep2 = mapper2.getdepbyid(2);
			System.out.println(dep2);
			session2.close();
			
			System.out.println(dep==dep2);
		}finally {
			
		}
          
	}
}
