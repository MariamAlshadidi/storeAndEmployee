package com.quiz.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="Employee")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	
    @ManyToOne()
    @JoinColumn(name ="store_id", nullable = false)
	private Store store;
    
    @NotNull
    @Size(min = 2, max = 200,  message="The name must be at least 2 characters.")
    private String name;


    @Min(value=18, message="Age must be greater than 18 " )
    private Integer age;
    
    @NotEmpty(message="The skill field is required.")
    private String skill;
    
    @NotEmpty(message="The status field is required.")
    private String status;
    
    
   //This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    
    
    public Employee() {
    }
    
    
    //Getters and setters
    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public String getSkill() {
		return skill;
	}



	public void setSkill(String skill) {
		this.skill = skill;
	}

	
    public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	



	public Store getStore() {
		return store;
	}



	public void setStore(Store store) {
		this.store = store;
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

