package com.pulseops.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="incidents")
public class Incident {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
    @Column(nullable = false)

	    private String title;
	    private String severity;
	    private String status;
	    
	    public Incident() {
	    }
	    
	    public Incident(Long id, String title, String severity, String status) {
	        this.id = id;
	        this.title = title;
	        this.severity = severity;
	        this.status = status;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getSeverity() {
	        return severity;
	    }

	    public void setSeverity(String severity) {
	        this.severity = severity;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
	}




