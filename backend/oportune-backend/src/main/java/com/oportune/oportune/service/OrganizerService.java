package com.oportune.oportune.service;

import com.oportune.oportune.model.Organizer;
import com.oportune.oportune.repository.OrganizerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrganizerService {

    private final OrganizerRepository organizerRepository;

    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Organizer getOrganizerById(Long id) {
        return organizerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Organizer with ID " + id + " not found"));
    }

    public Organizer createOrganizer(Organizer organizer) {
        if (organizer.getLinks() == null) {
            throw new IllegalArgumentException("Link cannot be null");
        }

        return organizerRepository.save(organizer);
    }

    public Organizer updateOrganizer(Long id, Organizer updatedOrganizer) {
        Organizer existingOrganizer = organizerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Organizer with ID " + id + " not found"));

        existingOrganizer.setName(updatedOrganizer.getName());
        existingOrganizer.setDescription(updatedOrganizer.getDescription());
        existingOrganizer.setLinks(updatedOrganizer.getLinks());

        return organizerRepository.save(existingOrganizer);
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }

}
