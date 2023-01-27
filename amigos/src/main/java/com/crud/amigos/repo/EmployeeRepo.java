package com.crud.amigos.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.amigos.model.Employee;

//CrudRepository alternative
public interface EmployeeRepo extends JpaRepository<Employee, Long>  {
	 
	//void deleteEmployeeById(Long id);
	
	Employee findEmployeeById(Long id);


}
