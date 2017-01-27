package com.twinsoft.service.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.twinsoft.domain.Patient;

public interface PatientService {

	Page<Patient> findAll(final Pageable pageable);
	
	Patient getPatient(final String firstname);
	
	Patient save(final Patient patient);
	
	void deletePatient(final String id);

}
