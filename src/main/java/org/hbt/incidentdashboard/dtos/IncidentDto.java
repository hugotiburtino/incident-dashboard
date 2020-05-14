package org.hbt.incidentdashboard.dtos;

public class IncidentDto {

	private int priority;
	private String timestamp;
	private String shortDescription;
	private String location;
	private String contact;
	private Long id;
	private String description;


	public IncidentDto() {}

	public IncidentDto(int priority, String timestamp, String shortDescription, 
			String location, String contact, Long id, String description) {
		super();
		this.priority = priority;
		this.timestamp = timestamp;
		this.shortDescription = shortDescription;
		this.location = location;
		this.contact = contact;
		this.id = id;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
