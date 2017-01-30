package com.twinsoft.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode( of = { "price", "treatmentDate" })
@ToString(exclude = {"doctor", "patient"})
public class Treatment implements Serializable {

	private static final long serialVersionUID = -662611264417102369L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private BigDecimal price;
	
	@Column(name = "treatmentdate", nullable = false)
	private Date treatmentDate;
	
    @ManyToOne(optional = false)
    @JoinColumn(name = "doctorid")
    @JsonBackReference(value = "doctor_treatments")
    private Doctor doctor;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "patientid")
    @JsonBackReference(value = "patient_treatments")
    private Patient patient;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "diagnose")
    @JsonManagedReference(value = "diagnose_treatments")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    private Diagnose diagnose;
	
}
