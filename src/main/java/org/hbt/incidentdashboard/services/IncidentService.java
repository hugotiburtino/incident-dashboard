package org.hbt.incidentdashboard.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hbt.incidentdashboard.dtos.IncidentDto;
import org.hbt.incidentdashboard.entities.Incident;
import org.hbt.incidentdashboard.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * Service that handles all actions related to incidents
 * 
 */
@Service
public class IncidentService {
	
	@Autowired
	private IncidentRepository incidentRepository;
	
	public IncidentService() {}

	/** 
	 * Function that save newly sent incident in the database
	 * A newly created incident receives all data given by the user, although
	 * some may be left empty. The time stamp is the time it is created 
	 * @param Long id
	 * @param int priority how urgent an incident should be resolved
	 * @param Long category_id classification of the incident
	 * @param String shortDescription a description of the incident written by the user, 
	 *   also used as title
	 * @param String location
	 * @param String contact
	 * @param String description a longer text written by the user 
	 * 
	 * @return Incident the incident saved in the database.	
	 */
	public Incident saveIncident(Long id, int priority, String shortDescription, String location, 
			String contact,	String description) {

		return incidentRepository.save(new Incident(id, priority, LocalDateTime.now(),
				shortDescription, location, contact, description));
	}
	
	
	/** 
	 * Returns an ArrayList of IncidentDtos(encapsulated under a List) of all incidents 
	 * that can be found in the database.
	 * 
	 * @return List of all incidents in the database as IncidentDto 
	 */
	public List<IncidentDto> listIncidents() {
		
		List<Incident> allIncidents = incidentRepository.findAll();
		
		List<IncidentDto> incidentList = new ArrayList<>();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		
		for (Incident incident: allIncidents) {
			String creationDate = dtf.format(incident.getTimestamp());
			IncidentDto dto = new IncidentDto(incident.getPriority(), creationDate, 
					incident.getShortDescription(),	incident.getLocation(), 
					incident.getContact(), incident.getId(), incident.getDescription());
			dto.setId(incident.getId());
			incidentList.add(dto);
		}
		
		return incidentList;

	}

	/** 
	 * Method for finding an incident in the database by its id
	 * 
	 * @param Long incidentId the id in the database of the incident that is searched
	 * @return IncidentDto with attributes of the found incident
	 */
	public IncidentDto findIncident(Long incidentId) {
		
		Optional<Incident> opt = incidentRepository.findById(incidentId);
		
		Incident incident = opt.get();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		
		String creationDate = dtf.format(incident.getTimestamp());
		
		IncidentDto dto = new IncidentDto(incident.getPriority(), creationDate,
				incident.getShortDescription(), incident.getLocation(), 
				incident.getContact(), incident.getId(), incident.getDescription());
		
		return dto;
	}

	
	/**
	 * Method for deleting an incident in the database by its id
	 * 
	 * @param Long incidentId the id in the database of the incident 
	 *   that is going to be deleted
	 */
	public void deleteIncidentInDB(Long incidentId) {
		
		incidentRepository.deleteById(incidentId);
		
	}
	
	/**
	 * Method for updating an incident in the database
	 * 
	 * @param IncidentDto sent by the user with the new data
	 */
	public void updateIncident(IncidentDto dto) {

		Optional<Incident> opt = incidentRepository.findById(dto.getId());
		
		Incident toUpDate = opt.get();
		
		toUpDate.setLocation(dto.getLocation());
		toUpDate.setContact(dto.getContact());
		toUpDate.setDescription(dto.getDescription());
		toUpDate.setShortDescription(dto.getShortDescription());
		toUpDate.setPriority(dto.getPriority());
		
		incidentRepository.save(toUpDate);
	}

}