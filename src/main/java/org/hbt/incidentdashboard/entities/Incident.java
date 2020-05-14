package org.hbt.incidentdashboard.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Incident {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private int priority;
	private LocalDateTime timestamp;
	private String shortDescription;
	private String location;
	private String contact;
	private String description;
  
    public Incident() {
		super();
	}
    
	public Incident(Long id, int priority, LocalDateTime timestamp, String shortDescription,
			String location, String contact, String description) {
		super();
		this.id = id;
		this.priority = priority;
		this.timestamp = timestamp;
		this.shortDescription = shortDescription;
		this.location = location;
		this.contact = contact;
		this.description = description;

	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Incident [id=" + id + ", description=" + description + ", timestamp=" + timestamp + "]";
	}


	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
