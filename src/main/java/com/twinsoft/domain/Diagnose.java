package com.twinsoft.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Diagnose implements Serializable {

	private static final long serialVersionUID = -662611264417102369L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column
	private String description;
	
    @OneToMany(mappedBy = "diagnoseid")
    @JsonIdentityReference(alwaysAsId=true)	
    private Set<Treatment> treatments = new HashSet<>();
}
