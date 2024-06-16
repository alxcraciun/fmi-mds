package com.oportune.oportune.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oportune.oportune.model.Organizer;
import com.oportune.oportune.service.OrganizerService;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/organizer")
public class OrganizerController {

    private final OrganizerService organizerService;

    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Organizer>> getAllOrganizers() {
        List<Organizer> organizers = organizerService.getAllOrganizers();
        return ResponseEntity.ok().body(organizers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
        Organizer organizer = organizerService.getOrganizerById(id);
        return ResponseEntity.ok().body(organizer);
    }

    @PostMapping("/create")
    public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer) {
        Organizer createdOrganizer = organizerService.createOrganizer(organizer);
        return new ResponseEntity<>(createdOrganizer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer updatedOrganizer) {
        Organizer organizer = organizerService.updateOrganizer(id, updatedOrganizer);
        return ResponseEntity.ok().body(organizer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
        return ResponseEntity.noContent().build();
    }

}
