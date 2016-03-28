package org.catais.ai.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Canton {

	private Integer id;
	
	private Integer fosnr;
	
	private String code;
	
	private String name;
	
	private String email;
	
	private Boolean activated;

	public Canton() {
		
	}
	
//	public Canton(int id, String code, String name) {
//		this.id = id;
//		this.code = code;
//		this.name = name;
//	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getFosnr() {
		return fosnr;
	}
	
	public void setFosnr(int fosnr) {
		this.fosnr = fosnr;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getActivated() {
		return activated;
	}
	
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
	
    @Override
    public String toString() {
        return new StringBuffer("Name : ").append(this.name)
        		.append("\nCode : ").append(this.code)
        		.append("\nFosNr : ").append(this.fosnr)
        		.append("\nE-Mail : ").append(this.email)
        		.append("\nID : ").append(this.id)
        		.append("\nActivated : ").append(this.activated).toString();
    }
}
