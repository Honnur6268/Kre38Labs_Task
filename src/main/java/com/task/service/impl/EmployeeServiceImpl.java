package com.task.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.model.Employee;
import com.task.repository.EmployeeRepository;
import com.task.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = repository.findAll();
		return employees;
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Optional<Employee> employeeById = repository.findById(employeeId);
		if (employeeById.isPresent()) {
			return employeeById.get();
		}
		return null;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		Employee saveEmployee = repository.save(employee);

		return saveEmployee;

	}

	@Override
	public Boolean deleteEmployeeById(Integer employeeId) {
		Optional<Employee> byId = repository.findById(employeeId);

		if (byId.isPresent()) {
			repository.deleteById(employeeId);
			return true;
		} else {

			return false;
		}
	}

}
