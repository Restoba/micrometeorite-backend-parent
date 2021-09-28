package de.restoba.terminverwaltungservice.entity.repository;

import de.restoba.terminverwaltungservice.entity.MicrometeoriteFindEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicrometeoriteFindRepository extends JpaRepository<MicrometeoriteFindEntity, Integer> {
}