package com.task.service;

import java.util.List;

import com.task.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Integer employeeId);

	Employee saveEmployee(Employee employee);

	Boolean deleteEmployeeById(Integer employeeId);
}
