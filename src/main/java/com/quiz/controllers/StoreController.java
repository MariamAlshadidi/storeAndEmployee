package com.quiz.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.quiz.models.Employee;
import com.quiz.models.Store;
import com.quiz.services.EmployeeService;
import com.quiz.services.StoreService;

@Controller
public class StoreController {
	
	//make access to the class StoreService
	private final StoreService storeService;
	private final EmployeeService employeeService;
	public StoreController(StoreService storeService, EmployeeService employeeService) {
		this.storeService = storeService;
		this.employeeService = employeeService;
	}

	
	// 1- create Store
	@RequestMapping(value="/store/create", method=RequestMethod.GET)
	public String createStoreView(
		@ModelAttribute("store") Store store) {
		return "Store/createStore.jsp";
	}
	
	@RequestMapping(value="/store/create", method=RequestMethod.POST)
	public String createStorePost(
            @Valid @ModelAttribute("store") Store store,
            BindingResult bindingResult,
			RedirectAttributes redirectAttributes
			) {
		if(bindingResult.hasErrors()) {
			return "Store/createStore.jsp";
		}
		
		storeService.createStore(store);
		redirectAttributes.addFlashAttribute("success", "Store has been craeted");
		return "redirect:/store/create";
	}
	
	
	
	// 2- get all Stores
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String getAllStores(Model model) {
		 List<Store> stores = storeService.getAll();
		 model.addAttribute("stores", stores);
		 
		 List<Store> activeStores = storeService.getAllActiveStore();
		 model.addAttribute("activeStores", activeStores);
		 
		 List<Employee> activeEmployees = employeeService.getAllActiveEmployees();
		 model.addAttribute("activeEmployees", activeEmployees);
		 
		 List<Employee> employees = employeeService.getAll();
		 model.addAttribute("employees", employees);
		 
		 return "dashboard.jsp";
	}
	
	
//	//get all Active Stores 
//	@RequestMapping(value="/active/stores", method=RequestMethod.GET)
//	public String getAllStoresActive(Model model) {
//		 List<Store> stores = storeService.getAllActiveStore();
//		 model.addAttribute("stores", stores);
//		 return "dashboard.jsp";
//	}
//	
	
	// 3- update store by Id    
 	@RequestMapping("/store/edit/{Id}")
 	// view all data about this store
 	public String viewStoreById(@PathVariable("Id") Long Id, Model model) {
 		Optional<Store> Optional = storeService.getStoreById(Id);
 		Store store = Optional.get();
 		model.addAttribute("store", store);
 		return "Store/updateStore.jsp";
 	}
 	
     @RequestMapping(value="/store/edit/{Id}", method=RequestMethod.PUT)
     public String update(
     		@PathVariable("Id") Long Id, 
     		@Valid @ModelAttribute("store") Store store,
     		BindingResult bindingResult,
     		RedirectAttributes redirectAttributes) 
     {
   
     	if (bindingResult.hasErrors()) {
        	redirectAttributes.addFlashAttribute("error", "somthing an error");
        	return "redirect:/store/edit/{Id}";
         } else {
        	 storeService.update(store, Id);
             return "redirect:/dashboard";
         }
     }
	
	
}
