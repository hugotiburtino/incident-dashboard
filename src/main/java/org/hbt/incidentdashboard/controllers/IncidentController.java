package org.hbt.incidentdashboard.controllers;

import java.util.List;
import org.hbt.incidentdashboard.dtos.IncidentDto;
import org.hbt.incidentdashboard.entities.Incident;
import org.hbt.incidentdashboard.services.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Controller that handles all endpoints related to incidents
 *
 */
@Controller
public class IncidentController {

	@Autowired
	private IncidentService incidentService;
	
	/**
	 * Get method for the index page
	 * 
	 * @param Model model
	 * @return String resources/templates/pages/index.html
	 *  
	 */
	@GetMapping("/incidents")
	public String showStartPage (Model model) {

		List<IncidentDto> incidents = incidentService.listIncidents();
		model.addAttribute("incidents", incidents);
			
		IncidentDto incidentDto = new IncidentDto();
		model.addAttribute("newIncident", incidentDto);
		
		return "pages/index";
		
	}
	
	/**
	 * Get method for the base URL 
	 * redirects to the /incidents endpoint
	 * 
	 * @return redirect:incidents
	 */
	@GetMapping("/")
	public String renderIndex () {
		
		return "redirect:/incidents";
		
	}
	
	/**
	 * Post method that sends fulfilled data of the form to the 
	 * IncidentService in order to save a new incident
	 * 
	 * @param IncidentDto newIncident
	 * @return String redirect to userincident.html
	 */
	@PostMapping("saveNewIncident")
	public String callSaveIncident(IncidentDto newIncident) {
		
		Incident savedIncident = incidentService.saveIncident(newIncident.getId(), 1,
				newIncident.getShortDescription(), newIncident.getLocation(), 
				newIncident.getContact(), newIncident.getDescription());
		
		return "redirect:/incident/" + savedIncident.getId();
		
	}
	
	/**
	 * Get method for the incident page
	 * 
	 * On this page the user has can see one chosen incident
	 * 
	 * @param Model model
	 * @return String resources/templates/pages/incident.html
	 */
	@GetMapping("/incident/{id}")
	public String showIncident (Model model, @PathVariable("id") Long id) {
		
		IncidentDto incident = incidentService.findIncident(id);
		model.addAttribute("incident", incident);
		
		return "pages/incident";
	}
	
	/**
	 * Get method for editincident page
	 * 
	 * On this page the user can edit an incident
	 * 
	 * @param Model model
	 * @param @PathVariable Long id the id of the incident to be edited
	 * @return String resources/template/pages/editincident.html
	 */
	@GetMapping("/incident/edit/{id}")
	public String showEditableIncident (Model model, @PathVariable("id") Long id) {
				
		IncidentDto incident = incidentService.findIncident(id);
		model.addAttribute("incident", incident);
		
		return "pages/editincident";
	}
	
	/**
	 * Post method that sends edited data of the form to the 
	 * IncidentService in order to update the incident
	 * 
	 * The incidentDto that the user fulfilled receives the id of the incident
	 * that is going to be updated and is sent to update method of the IncidentService
	 * 
	 * @param IncidentDto dto with updated data
	 * @param @PathVariable Long id the id of the edited incident
	 * @return String redirect to index.html
	 */
	@PostMapping("/incident/update/{id}")
	public String callUpdateIncident(IncidentDto incident, @PathVariable("id") Long id) {
		
		incident.setId(id);
		incidentService.updateIncident(incident);
		
		return "redirect:/incidents";
	}
	
	/**
	 * Get method to delete an incident
	 * 
	 * @param @PathVariable Long id
	 * @return String redirect to index.html 
	 */
	@GetMapping("/incident/delete/{id}")
	public String eraseIncident(@PathVariable("id") Long id) {
		
		incidentService.deleteIncidentInDB(id);

		return "redirect:/incidents";
	}
}
