package com.baldurtech.event;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

@Repository
public class EventRepository {
    @PersistenceContext
    EntityManager entityManager;
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Event> findAll() {
        return entityManager.createNamedQuery(Event.FIND_ALL, Event.class).getResultList();
    }
    
    public Event save(Event event) {
        
        System.out.println(event.getName());
        return event;
    }
}