package com.crud.amigos.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.amigos.model.Employee;
import com.crud.amigos.repo.EmployeeRepo;
import com.crud.amigos.exception.UserNotFoundException;

@Service
public class EmployeeService {
	
	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees() {
		
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Long id, Employee employee) {

		Employee e1 = employeeRepo.findEmployeeById(id);
		
		if (employee.getName() != null) {
			e1.setName(employee.getName());
		}
		
		if (employee.getEmail() != null) {
			e1.setEmail(employee.getEmail());
		}
		
		if (employee.getJobTitle() != null) {
			e1.setJobTitle(employee.getJobTitle());
		}
		
		if (employee.getPhone() != null) {
			e1.setPhone(employee.getPhone());
		}
		
		if (employee.getImageUrl() != null) {
			e1.setImageUrl(employee.getImageUrl());
		}
		
		if (employee.getDob() != null) {
			e1.setDob(employee.getDob());
		}
			
		return employeeRepo.save(e1);
	}
	
	public Employee replaceEmployee(Long id, Employee employee) {
		System.out.println(employee.toString());
		employeeRepo.deleteById(id);
		
		employee.setId(id);
		System.out.println(employee.toString());
		
		employee.setEmployeeCode(UUID.randomUUID().toString());
		System.out.println(employee.toString());

		
		
		//figure out how to replace with the same id
		return employeeRepo.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		
		return employeeRepo.findEmployeeById(id);//could use findById(id) from CrudRepository
				//.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	}
	
	public void deleteEmployee(Long id) {
		
		employeeRepo.deleteById(id);//could use deleteById(id) from CrudRepository
	}

}
