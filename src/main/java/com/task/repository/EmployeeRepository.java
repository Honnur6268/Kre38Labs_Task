package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
