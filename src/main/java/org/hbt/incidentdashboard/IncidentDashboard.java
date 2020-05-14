package org.hbt.incidentdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * Incident Dashboard 
 * 
 * An Spring Boot Web Application
 * 
 * A pin board where every person with access to it can read, add, update or delete
 * incident reports.
 * 
 * Class that initializes the application 
 *  
 */
@SpringBootApplication
public class IncidentDashboard {

	public static void main(String[] args) {
		SpringApplication.run(IncidentDashboard.class, args);
	}

}
