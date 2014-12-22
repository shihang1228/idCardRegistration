package com.baldurtech.event;

import java.sql.Date;

public class Event {
    private Long id;
    private String name;
    private Date dateCreated;
    
    public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
	}  
    
    public String getName() {
		return name;
	}
    
	public void setName(String name) {
		this.name = name;
	}
    
    public Date getDateCreated() {
		return dateCreated;
	}
    
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}