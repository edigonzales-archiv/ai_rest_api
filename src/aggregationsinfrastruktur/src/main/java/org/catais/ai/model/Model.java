package org.catais.ai.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Model {
	
	private Integer id;
		
	private String name;
	
	private String schemaLanguage;
	
	private String version;
	
	private Date publishingDate;
	
	private String repository;
	
	private Boolean activated;

	public Model() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public String getRepository() {
		return repository;
	}
	
	public void setRepository(String repository) {
		this.repository = repository;
	}
	
	public Boolean getActivated() {
		return activated;
	}
	
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
	
    @Override
    public String toString() {
        return new StringBuffer("ID : ").append(this.id)
        		.append("\nName : ").append(this.name)        		
        		.append("\nSchema language : ").append(this.schemaLanguage)
        		.append("\nVersion : ").append(this.version)
        		.append("\nPublishing date : ").append(this.publishingDate)
        		.append("\nRepository : ").append(this.repository).toString();
    }

}
