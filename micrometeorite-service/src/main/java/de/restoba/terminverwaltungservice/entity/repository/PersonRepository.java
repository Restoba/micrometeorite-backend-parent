package de.restoba.terminverwaltungservice.entity.repository;

import de.restoba.terminverwaltungservice.entity.MicrometeoriteFindEntity;
import de.restoba.terminverwaltungservice.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
}
