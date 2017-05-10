package com.twinsoft.service.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.twinsoft.domain.Patient;

interface PatientRepository extends CrudRepository<Patient, Long> {
	Page<Patient> findAll(Pageable pageable);
	Patient findByFirstnameIgnoringCase(String firstname);
	Patient findById(String id);
}
