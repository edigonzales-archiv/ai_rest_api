package org.catais.ai.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Model {
	
	private int id;
		
	private String name;
	
	private String schemaLanguage;
	
	private String version;
	
	private Date publishingDate;
	
	private boolean activated;

	public Model() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSchemaLanguage() {
		return schemaLanguage;
	}
	
	public void setSchemaLanguage(String schemaLanguage) {
		this.schemaLanguage = schemaLanguage;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public Date getPublishingDate() {
		return publishingDate;
	}
	
	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}
	
	public boolean getActivated() {
		return activated;
	}
	
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
}
