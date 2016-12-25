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
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String firstname;	
	@Column(nullable = false)
	private String lastname;
	@Column
	private String middlename;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String place;    
	@Column(nullable = false)
	private Date birthdate;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String mobilephone;
	@Column
	private String photo;
//	@Column(nullable = false)
//	private String allergies;
//	@Column(nullable = false)
//	private String notes;
	
	protected Patient() {		
	}
	
	public Patient(String firstname) {
		super();
		this.firstname = firstname;
	}




}
