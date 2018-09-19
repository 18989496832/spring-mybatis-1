package com.kcy.mybatis.Dao;

import com.kcy.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	public Employee getEmployeeById(Integer id);
}
