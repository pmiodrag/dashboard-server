package com.twinsoft.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = { "price", "treatmentdate" })
@ToString(exclude = {"doctor", "patient"})
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


	
    /*@ManyToOne(optional = false)
    @JoinColumn(name = "doctorid")
    @JsonBackReference(value = "doctor_treatments")
   // @JsonProperty(access = Access.READ_ONLY)
    private Doctor doctor;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "patientid")
    @JsonBackReference(value = "patient_treatments")
   // @JsonProperty(access = Access.READ_ONLY)
    private Patient patient;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "diagnose")
    @JsonManagedReference(value = "diagnose_treatments")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
  //  @JsonProperty(access = Access.READ_ONLY)
    private Diagnose diagnose;*/

	
}
