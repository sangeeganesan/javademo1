package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {
	public abstract Employee       addEmployee(Employee employee);
	public abstract Employee       readEmployeeById(int empId);
	public abstract List<Employee> listEmployee();

}
