package com.twinsoft.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TreatmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public TreatmentDTO(Object[] objects) {
		this.treatmentDate = (Date) objects[0];
		this.therapy = objects[1].toString();
		this.price = objects[2].toString();
		this.patientName = objects[3].toString();
		this.doctorName = objects[4].toString();
		this.diagnoseName = objects[4].toString();
	}

	private String price;
	
	private Date treatmentDate;
	
	private String therapy;
	
	private String patientName;
	
	private String doctorName;	
	
	private String diagnoseName;
}
