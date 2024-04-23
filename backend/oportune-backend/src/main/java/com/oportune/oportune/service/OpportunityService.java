package com.oportune.oportune.service;

import com.oportune.oportune.model.Opportunity;
import com.oportune.oportune.repository.OpportunityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OpportunityService {

    private final OpportunityRepository opportunityRepository;

    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public Opportunity getOpportunityById(Long id) {
        return opportunityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Opportunity with ID " + id + " not found"));
    }
    public Opportunity createOpportunity(Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }

    public List<Opportunity> getOpportunitiesByType(Long typeId) {
        return opportunityRepository.findByTypeId(typeId);
    }

    public List<Opportunity> getOpportunitiesByCategory(Long categoryId) {
        return opportunityRepository.findByCategoryId(categoryId);
    }

    public Opportunity updateOpportunity(Long id, Opportunity updatedOpportunity) {
        Opportunity existingOpportunity = opportunityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Opportunity with ID " + id + " not found"));

        existingOpportunity.setName(updatedOpportunity.getName());
        existingOpportunity.setDescription(updatedOpportunity.getDescription());
        existingOpportunity.setLink(updatedOpportunity.getLink());
        existingOpportunity.setLocation(updatedOpportunity.getLocation());
        existingOpportunity.setStart_date(updatedOpportunity.getStart_date());
        existingOpportunity.setEnd_date(updatedOpportunity.getEnd_date());
        existingOpportunity.setStatus(updatedOpportunity.getStatus());
        existingOpportunity.setType(updatedOpportunity.getType());
        existingOpportunity.setCategory(updatedOpportunity.getCategory());
        existingOpportunity.setOrganizer(updatedOpportunity.getOrganizer());

        return opportunityRepository.save(existingOpportunity);
    }

    public void deleteOpportunity(Long id) {
        opportunityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Opportunity with ID " + id + " not found"));
        opportunityRepository.deleteById(id);
    }
}

