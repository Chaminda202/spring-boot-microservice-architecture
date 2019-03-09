package com.spring.cloud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spring.cloud.entity.Employee;
import com.spring.cloud.repository.EmployeeRepository;
import com.spring.cloud.request.EmployeeRequest;

import javassist.NotFoundException;

@Service
public class EmployeeService {
	private Logger logger;
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.logger = LoggerFactory.getLogger(this.getClass());
		this.employeeRepository = employeeRepository;
	}

	public Employee addEmployee(EmployeeRequest request) {
		logger.info("{} -> {} -> {}", "Add Employee", "SERVICE", request.getName());
		return employeeRepository.save(new Employee(request));
	}

	public Employee updateEmployee(EmployeeRequest request) throws NotFoundException {
		logger.info("{} -> {} -> {}", "Update Employee", "SERVICE", request.getName());
		return employeeRepository.findById(request.getEmployeeId())
				.orElseThrow(() -> new NotFoundException("Record not found for " + request.getEmployeeId()));
	}

	public Employee getEmployeeByName(String name) throws NotFoundException {
		logger.info("{} -> {} -> {}", "Get Employee", "SERVICE", name);
		return employeeRepository.findByName(name)
				.orElseThrow(() -> new NotFoundException("Record not found for " + name));
	}

	public List<Employee> getAllEmployee(){
		logger.info("{} -> {}", "Get All Employee", "SERVICE");
		return employeeRepository.findAll();
	}

	public Employee deleteEmployeeById(int empId) throws NotFoundException {
		logger.info("{} -> {} -> {}", "Delete Employee By Id ", "SERVICE", empId);
		Employee employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new NotFoundException("Record not found for " + empId));
		employeeRepository.deleteById(empId);
		return employee;
	}
	
	public Employee deleteEmployeeByName(String name) throws NotFoundException {
		logger.info("{} -> {} -> {}", "Delete Employee By Name ", "SERVICE", name);
		Employee employee = employeeRepository.findByName(name)
				.orElseThrow(() -> new NotFoundException("Record not found for " + name));
		employeeRepository.delete(employee);
		return employee;
	}
}
