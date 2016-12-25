package com.twinsoft.service;

import org.springframework.data.repository.Repository;

import com.twinsoft.domain.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

interface PatientRepository extends CrudRepository<Patient, Long> {
	Page<Patient> findAll(Pageable pageable);
	Patient findByFirstnameIgnoringCase(String firstname);
//    void delete(String id);
}
