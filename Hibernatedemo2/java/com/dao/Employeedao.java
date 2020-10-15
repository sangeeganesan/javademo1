package com.dao;

import java.util.List;

import com.model.Employee;

public interface Employeedao {

	public abstract Employee createEmployee(Employee employee);

	public abstract Employee readByEmployeeId(int empId);
	
	public abstract Employee readByEmployeeName(String eName);

	public abstract Employee updateEmployee(Employee employee);

	public abstract int deleteByEmployeeId(int empId);
	
	public abstract int deleteByEmployeeName(String eName);
	
	public abstract List<Employee> listAllEmployee();

}
