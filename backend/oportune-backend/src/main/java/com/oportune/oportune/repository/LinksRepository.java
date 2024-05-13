package com.oportune.oportune.repository;

import com.oportune.oportune.model.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinksRepository extends JpaRepository<Links, Long> {
}

