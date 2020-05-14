package org.hbt.incidentdashboard.repositories;

import org.hbt.incidentdashboard.entities.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long>{ }