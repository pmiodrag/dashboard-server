package com.twinsoft.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode( of = { "firstname", "lastname" })
public class Patient implements Serializable {

	private static final long serialVersionUID = 3451665468746321533L;

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
	
	@Column
	private String allergies;
	
	@Column
	private String notes;
	
    @OneToMany(mappedBy = "patient", cascade = { CascadeType.MERGE, CascadeType.PERSIST }, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference(value = "patient_treatments")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    private Set<Treatment> treatments = new HashSet<>();
}
