package com.twinsoft.service.patient;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.twinsoft.domain.Patient;

@Component("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {

	private final PatientRepository patientRepository;
	
	public PatientServiceImpl(final PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	@Override
	public Patient getPatient(final String firstname) {
		return this.patientRepository.findByFirstnameIgnoringCase(firstname);
	}

	@Override
	public Page<Patient> findAll(final Pageable pageable) {
		return this.patientRepository.findAll(pageable);
	}

	@Override
	public void deletePatient(final String id) {
		this.patientRepository.delete(Long.parseLong(id));		
	}

	@Override
	public Patient save(final Patient patient) {
		return this.patientRepository.save(patient);
	}

}
