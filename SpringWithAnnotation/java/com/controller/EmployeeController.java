package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.model.Employee;
import com.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/add")
	public String add(@ModelAttribute Employee employeeController,Model model)
	{
		Employee var=employeeService.addEmployee(employeeController);
		model.addAttribute("key1", var);
		return "success";
	}
	@GetMapping(value="/read{alias}")
	public String read(@PathVariable ("alias")int id,Model model)
	{
		Employee temp=employeeService.readEmployeeById(id);
		model.addAttribute("key2",temp);
		return "readview";
	}
	@GetMapping(value="/all")
	public String displayAllEmployee(Model model)
	{
		List<Employee> empList=employeeService.listEmployee();
		model.addAttribute("key3", empList);
		return "showAll";
	}

}
