
package com.pulseops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulseops.model.Incident;
import com.pulseops.repository.IncidentRepository;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    // READ: Get all incidents
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    // READ: Get one incident by ID
    public Incident getIncidentById(Long id) {
        return incidentRepository.findById(id).orElse(null);
    }

    // CREATE: Save an incident
    public void addIncident(Incident incident) {
        incidentRepository.save(incident);
    }

    // PUT: Update all editable fields
    public boolean updateIncident(Long id, Incident updatedIncident) {
        Incident existingIncident = getIncidentById(id);

        if (existingIncident == null) {
            return false;
        }

        existingIncident.setTitle(updatedIncident.getTitle());
        existingIncident.setSeverity(updatedIncident.getSeverity());
        existingIncident.setStatus(updatedIncident.getStatus());

        incidentRepository.save(existingIncident);
        return true;
    }

    // PATCH: Update only provided fields
    public boolean patchIncident(Long id, Incident updatedIncident) {
        Incident existingIncident = getIncidentById(id);

        if (existingIncident == null) {
            return false;
        }

        if (updatedIncident.getTitle() != null) {
            existingIncident.setTitle(updatedIncident.getTitle());
        }

        if (updatedIncident.getSeverity() != null) {
            existingIncident.setSeverity(updatedIncident.getSeverity());
        }

        if (updatedIncident.getStatus() != null) {
            existingIncident.setStatus(updatedIncident.getStatus());
        }

        incidentRepository.save(existingIncident);
        return true;
    }

    // DELETE: Remove an incident
    public boolean deleteIncident(Long id) {
        if (!incidentRepository.existsById(id)) {
            return false;
        }

        incidentRepository.deleteById(id);
        return true;
    }
}
