package com.pulseops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pulseops.model.Incident;
import com.pulseops.service.IncidentService;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
	
	@Autowired
	private IncidentService incidentservice;
	
	//Get All Incidents
	@GetMapping
	public List<Incident> getAllIncidents(){
		return incidentservice.getAllIncidents();
	}
	
	//Get Incidents by Id
	 @GetMapping("/{id}")
	    public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
	        Incident incident = incidentservice.getIncidentById(id);

	        if (incident == null) {
	            return ResponseEntity.notFound().build();
	        }

	        return ResponseEntity.ok(incident);
	    }
	 
	 // POST: Create an incident
	    @PostMapping
	    public ResponseEntity<String> addIncident(@RequestBody Incident incident) {
	        incidentservice.addIncident(incident);

	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body("Incident added successfully");
	    }
	    
	    // 4. PUT - Update an existing incident
	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateIncident(
	            @PathVariable Long id,
	            @RequestBody Incident incident) {

	        boolean updated =
	                incidentservice.updateIncident(id, incident);

	        if (!updated) {
	            return ResponseEntity.notFound().build();
	        }

	        return ResponseEntity.ok("Incident updated successfully");
	    }
	    
	    // DELETE: Delete an incident
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
	        boolean deleted = incidentservice.deleteIncident(id);

	        if (!deleted) {
	            return ResponseEntity.notFound().build();
	        }

	        return ResponseEntity.noContent().build();
	    }
	}
	 
	 
	


