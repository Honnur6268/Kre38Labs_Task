package com.task.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Employee;
import com.task.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = service.getAllEmployees();

		if (allEmployees.isEmpty()) {
			return new ResponseEntity<>(allEmployees, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
		Employee employee = service.getEmployeeById(employeeId);
		if (employee != null) {
			return new ResponseEntity<>(employee, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(employee, HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<String> insertEmployee(@RequestBody Employee employee) {

		Employee saveEmployee = service.saveEmployee(employee);
		if (saveEmployee != null) {
			return new ResponseEntity<>("Employee Added Successfuly", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Error ocurred during ading Employee!!", HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Integer employeeId) {

		Boolean status = service.deleteEmployeeById(employeeId);
		if (status) {

			return new ResponseEntity<>("Employee Id: " + employeeId + " deleted Successfuly", HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee Id: " + employeeId + " Not Found", HttpStatus.NOT_FOUND);
	}
}
