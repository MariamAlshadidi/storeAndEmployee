package com.quiz.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quiz.models.Store;



@Repository
	public interface StoreRepository extends CrudRepository<Store, Long>{

	    List<Store> findAll();
	    
	    @Query("SELECT d FROM Store d WHERE status ='Active' ")
	    List<Store> getStoreWhereStatus();
	 
	
	}
	



