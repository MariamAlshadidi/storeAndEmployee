package com.quiz.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quiz.models.Employee;





@Repository
	public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	    List<Employee> findAll();
	    
	    @Query("SELECT d FROM Employee d WHERE status ='Active' ")
	    List<Employee> getEmployeeWhereStatus();
	}
	



