package com.twinsoft.service.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.twinsoft.domain.Patient;

public interface PatientService {

	Page<Patient> findAll(Pageable pageable);
	Patient getPatient(String firstname);
	Patient getPatientById(String id);
	Patient save(Patient patient);
	void deletePatient(String id);

}
