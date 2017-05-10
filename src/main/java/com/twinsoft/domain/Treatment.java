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
public class Treatment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private Long patientid;
	@Column(nullable = false)
	private Long doctorid; 
	@Column(nullable = false)
	private Date treatmentdate;
	@Column(nullable = false)
	private String therapy;
	@Column(nullable = false)
	private Long diagnoseid;
	@Column(nullable = false)
	private String price;
	
	protected Treatment() {		
	}
	
}
