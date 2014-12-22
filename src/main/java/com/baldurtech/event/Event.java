package com.baldurtech.event;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "event")
@NamedQuery(name = Event.FIND_ALL, query = "from Event")
public class Event {
    public static final String FIND_ALL = "Event.findAll";
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    
    @Temporal( value = TemporalType.TIMESTAMP )
    private Date dateCreated;
    
    @PrePersist
    protected void onCreate() {
        dateCreated = new Date();
    }
    
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