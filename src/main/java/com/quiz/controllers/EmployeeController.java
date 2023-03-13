package com.quiz.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.quiz.models.Employee;
import com.quiz.models.Store;
import com.quiz.services.EmployeeService;
import com.quiz.services.StoreService;


@Controller
public class EmployeeController {
	
	//make access to the class StoreService
	private final EmployeeService employeeService;
	private final StoreService storeService;
	public EmployeeController(EmployeeService employeeService,StoreService storeService) {
		this.employeeService = employeeService;
		this.storeService = storeService;
	}

	
	// 1- create Store
	@RequestMapping(value="/employee/create", method=RequestMethod.GET)
	public String createStoreView(
		Model model,
		@ModelAttribute("employee") Employee employee) {
		 List<Store> stores = storeService.getAll();
		 model.addAttribute("stores", stores);
		return "Employee/createEmployee.jsp";
	}
	
	@RequestMapping(value="/employee/create", method=RequestMethod.POST)
	public String createStorePost(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult,
			RedirectAttributes redirectAttributes
			) {
		if(bindingResult.hasErrors()) {
			return "Employee/createEmployee.jsp";
		}
		
		employeeService.createEmployee(employee);
		redirectAttributes.addFlashAttribute("success", "Employee has been craeted");
		return "redirect:/employee/create";
	}
	
	
	
	// 2- get all Employees
	@RequestMapping(value="/dashboard/employees", method=RequestMethod.GET)
	public String getAllEmployees(Model model) {
		 List<Employee> employees = employeeService.getAll();
		 model.addAttribute("employees", employees);
		 
		 return "dashboard.jsp";
	}
	
	
	// 3- update Employee by Id    
 	@RequestMapping("/employee/edit/{Id}")
 
 	public String viewEmployeeById(@PathVariable("Id") Long Id, Model model) {
 		Optional<Employee> Optional = employeeService.getEmployeeById(Id);
 		Employee employee = Optional.get();
 		model.addAttribute("employee", employee);
 		
		 List<Store> stores = storeService.getAll();
		 model.addAttribute("stores", stores);
		 
 		return "Employee/updateEmployee.jsp";
 	}
 	
     @RequestMapping(value="/employee/edit/{Id}", method=RequestMethod.PUT)
     public String update(
     		@PathVariable("Id") Long Id, 
     		@Valid @ModelAttribute("employee") Employee employee,
     		BindingResult bindingResult,
     		RedirectAttributes redirectAttributes) 
     {
   
     	if (bindingResult.hasErrors()) {
        	redirectAttributes.addFlashAttribute("error", "somthing an error");
        	redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employee", bindingResult);
        	return "redirect:/employee/edit/{Id}";
         } else {
        	 employeeService.update(employee, Id);
             return "redirect:/dashboard";
         }
     }
     
     // delete Employee
     @RequestMapping(value="/delete/employee/{id}", method=RequestMethod.DELETE)
      public String deleteEmployee(@PathVariable("id") Long id) {
    	 employeeService.delete(id);
       return "redirect:/dashboard";
     } 
	
	
}
