package com.ibm.bts.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Bug {
	@NotNull
	@NotBlank
	private String description;

	@NotNull
	private String status;
	@Id
	private String id;
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		String[] statusBug = {"New","Assigned","Open","Fixed"};
		for(String bugStatus : statusBug ) {
			
			if(bugStatus.equals(status)) {

				this.status = status;
			}
			else
			{
				throw new IllegalArgumentException();
				}
		}
				
		
		
	}

	

}
