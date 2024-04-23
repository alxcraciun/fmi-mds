package com.oportune.oportune.repository;

import com.oportune.oportune.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    Optional<Opportunity> findById(Long id);
    List<Opportunity> findByTypeId(Long typeId);
    List<Opportunity> findByCategoryId(Long categoryId);

}

