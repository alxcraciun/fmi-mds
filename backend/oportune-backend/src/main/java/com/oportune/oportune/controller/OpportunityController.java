package com.oportune.oportune.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oportune.oportune.model.Opportunity;
import com.oportune.oportune.service.OpportunityService;

import java.util.List;

@RestController
@RequestMapping("/opportunity")
public class OpportunityController {

    private final OpportunityService opportunityService;

    public OpportunityController(OpportunityService opportunityService) {
        this.opportunityService = opportunityService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opportunity> getOpportunityById(@PathVariable Long id) {
        Opportunity opportunity = opportunityService.getOpportunityById(id);
        return ResponseEntity.ok().body(opportunity);
    }

    @PostMapping("/create")
    public ResponseEntity<Opportunity> createOpportunity(@RequestBody Opportunity opportunity) {
        Opportunity createdOpportunity = opportunityService.createOpportunity(opportunity);
        return new ResponseEntity<>(createdOpportunity, HttpStatus.CREATED);
    }

    @GetMapping("/by-type")
    public ResponseEntity<List<Opportunity>> getOpportunitiesByType(@RequestParam("type") Long typeId) {
        List<Opportunity> opportunities = opportunityService.getOpportunitiesByType(typeId);
        return ResponseEntity.ok().body(opportunities);
    }

    @GetMapping("/by-category")
    public ResponseEntity<List<Opportunity>> getOpportunitiesByCategory(@RequestParam("category") Long categoryId) {
        List<Opportunity> opportunities = opportunityService.getOpportunitiesByCategory(categoryId);
        return ResponseEntity.ok().body(opportunities);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Opportunity> updateOpportunity(@PathVariable Long id, @RequestBody Opportunity updatedOpportunity) {
        Opportunity opportunity = opportunityService.updateOpportunity(id, updatedOpportunity);
        return ResponseEntity.ok().body(opportunity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOpportunity(@PathVariable Long id) {
        opportunityService.deleteOpportunity(id);
        return ResponseEntity.noContent().build();
    }
}


