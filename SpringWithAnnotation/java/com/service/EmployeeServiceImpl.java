package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	public Employee addEmployee(Employee employee) {
		String var=employee.getEmpName();
		employee.setEmpName(var + "from service");
		return employee;
	}

	public Employee readEmployeeById(int empId) {
		Employee employee=null;
		if(empId==10)
		{
			employee=new Employee(10,"Ten",1010f);
		}
		if(empId ==20) {
			employee=new Employee(10,"Twenty",2020f);
		}
		return employee;
	}

	public List<Employee> listEmployee() {
		Employee employee1=new Employee(100,"One Hundered",100f);
		Employee employee2=new Employee(200,"TWO Hundered",200f);
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		return employees;
	}

}
