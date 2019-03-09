package com.spring.cloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.request.EmployeeRequest;
import com.spring.cloud.response.EmployeeResponse;
import com.spring.cloud.service.EmployeeService;
import com.spring.cloud.util.JacksonUtil;

@RestController
@RequestMapping(value="/rest")
public class EmployeeController {
	private Logger logger;
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService){
		this.logger = LoggerFactory.getLogger(this.getClass());
		this.employeeService = employeeService;
	}
	//@RequestMapping(value="/employee", method=RequestMethod.POST)
	@PostMapping(value="/employee")
	@ResponseBody
	public EmployeeResponse addEmployee(@RequestBody EmployeeRequest request) {
		logger.info("{} -> {} -> {}", "Add Employee ", "CONTROLLER", JacksonUtil.getToString(request));
		return new EmployeeResponse(employeeService.addEmployee(request));
	}
	
	//@RequestMapping(value="/employee", method=RequestMethod.PUT)
	@PutMapping(value="/employee")
	@ResponseBody
	public EmployeeResponse updateEmployee(@RequestBody EmployeeRequest request){
		logger.info("{} -> {} -> {}", "Update Employee", "CONTROLLER", JacksonUtil.getToString(request));
		EmployeeResponse response = new EmployeeResponse();
		try{
			return new EmployeeResponse(employeeService.updateEmployee(request));
		}catch (Exception e) {
			logger.error("{} -> {} -> {}", "Update Employee", "CONTROLLER", e.getMessage());
		}
		return response;
	}
	
	@GetMapping(value="/employee/{name}")
	@ResponseBody
	public EmployeeResponse getEmployeeByName(@PathVariable String name){
		logger.info("{} -> {} -> {}", "Get Employee", "CONTROLLER", name);
		EmployeeResponse response = new EmployeeResponse();
		try{
			return new EmployeeResponse(employeeService.getEmployeeByName(name));
		}catch (Exception e) {
			logger.error("{} -> {} -> {}", "Get Employee", "CONTROLLER", e.getMessage());
		}
		return response;
	}
	
	@GetMapping(value="/employee")
	@ResponseBody
	public List<EmployeeResponse> getAllEmployee(){
		logger.info("{} -> {}", "Get All Employee", "CONTROLLER");
		List<EmployeeResponse> responseList = new ArrayList<>();
		employeeService.getAllEmployee().forEach(item -> {
			responseList.add(new EmployeeResponse(item));
		});
		return responseList;
	}
	
	@DeleteMapping(value="/employee/{empId}")
	@ResponseBody
	public EmployeeResponse deleteEmployeeById(@PathVariable int empId){
		logger.info("{} -> {} -> {}", "Delete Employee By Id", "CONTROLLER", empId);
		EmployeeResponse response = new EmployeeResponse();
		try{
			return new EmployeeResponse(employeeService.deleteEmployeeById(empId));
		}catch (Exception e) {
			logger.error("{} -> {} -> {}", "Delete Employee By Id", "CONTROLLER", e.getMessage());
		}
		return response;
	}
	
	@DeleteMapping(value="/employee")
	@ResponseBody
	public EmployeeResponse deleteEmployeeByName(@RequestParam String name) {
		logger.info("{} -> {} -> {}", "Delete Employee By Name", "CONTROLLER", name);
		EmployeeResponse response = new EmployeeResponse();
		try{
			return new EmployeeResponse(employeeService.deleteEmployeeByName(name));
		}catch (Exception e) {
			logger.error("{} -> {} -> {}", "Delete Employee By Name", "CONTROLLER", e.getMessage());
		}
		return response;
	}
}
