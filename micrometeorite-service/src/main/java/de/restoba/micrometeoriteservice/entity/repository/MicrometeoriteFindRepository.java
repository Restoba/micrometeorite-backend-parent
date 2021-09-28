package de.restoba.micrometeoriteservice.entity.repository;

import de.restoba.micrometeoriteservice.entity.MicrometeoriteFindEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicrometeoriteFindRepository extends JpaRepository<MicrometeoriteFindEntity, Integer> {
}
