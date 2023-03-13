package com.quiz.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.quiz.models.Store;
import com.quiz.repositories.StoreRepository;



@Service
public class StoreService {
	
    // adding the book repository as a dependency
    private final StoreRepository storeRepository;
 
    //make access to all method inside Repo
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
    
    
    // get all Stores
    public List<Store> getAll() {
  	return storeRepository.findAll();
    }
    
    // get all Active Stores
    public List<Store> getAllActiveStore() {
  	return storeRepository.getStoreWhereStatus();
    }
    
    
    // create a store
    // take store from controller with data to save it in DB
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }
    
     //Optional >> means this store maby empty
    public Optional<Store> getStoreById(Long storeId) {
    	return storeRepository.findById(storeId);
    }
    
    
//    public void delete(Long id) {
//    	bookRepository.deleteById(id);
//    }
//    
    
        public Store update(Store ele ,Long Id) {
    	Optional<Store> Optional = storeRepository.findById(Id);
    	if(Optional.isPresent()) {
    		Store store = Optional.get();	
    		store.setName(ele.getName());
    		store.setAddress(ele.getAddress());
    		store.setStore_type(ele.getStore_type());
    		store.setStatus(ele.getStatus());
    		storeRepository.save(store);	
    		return store;
    	}
    	return null;  
    }
    
        

}
