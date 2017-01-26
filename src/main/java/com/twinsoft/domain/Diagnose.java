package com.twinsoft.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Diagnose implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	private String description;
	
	protected Diagnose() {		
	}
	
	public Diagnose(String firstname) {
		super();
		this.name = name;
	}




}
