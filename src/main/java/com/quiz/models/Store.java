package com.quiz.models;


import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Store")
public class Store {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    
	@NotNull
    @Size(min = 2, max = 200,  message="The name must be at least 2 characters.")
    private String name;

    @NotNull
    @Size(min = 2, max = 200,  message="The address must be at least 2 characters.")
    private String address;
    
    @NotEmpty(message="The Store Type field is required.")
    private String store_type;
    
    @NotEmpty(message="The Status field is required.")
    private String status;
    
    //One to Many >> one store has many employees
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Employee> employees;

    
   //This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
   
    
    public Store() {
    }
    
    
    //Getters and setters
    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getStore_type() {
		return store_type;
	}


	public void setStore_type(String store_type) {
		this.store_type = store_type;
	}

	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}



	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
   
    
    
}





