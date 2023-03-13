package com.quiz.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.quiz.models.Employee;
import com.quiz.models.Store;
import com.quiz.repositories.EmployeeRepository;
import com.quiz.repositories.StoreRepository;



@Service
public class EmployeeService {
	
    // adding the book repository as a dependency
    private final EmployeeRepository employeeRepository;
 
    //make access to all method inside Repo
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
 // get all Employees
    public List<Employee> getAll() {
  	return employeeRepository.findAll();
    }
    
    
    // get all Active Employees
    public List<Employee> getAllActiveEmployees() {
  	return employeeRepository.getEmployeeWhereStatus();
    }
    
    // create a store
    // take employee from controller with data to save it in DB
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
     //Optional >> means this store maby empty
    public Optional<Employee> getEmployeeById(Long employeeId) {
    	return employeeRepository.findById(employeeId);
    }
    

        public Employee update(Employee ele ,Long Id) {
    	Optional<Employee> Optional = employeeRepository.findById(Id);
    	if(Optional.isPresent()) {
    		Employee employee = Optional.get();	
    		employee.setName(ele.getName());
    		employee.setAge(ele.getAge());
    		employee.setSkill(ele.getSkill());
    		employee.setStatus(ele.getStatus());
    		employee.setStore(ele.getStore());
    		employeeRepository.save(employee);	
    		return employee;
    	}
    	return null;  
    }
    
      //Delete Employee by Id 
      public void delete(Long id) {
    	  employeeRepository.deleteById(id);
    }
      

}
