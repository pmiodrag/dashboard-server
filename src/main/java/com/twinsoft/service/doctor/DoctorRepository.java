package com.twinsoft.service.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.twinsoft.domain.Doctor;

interface DoctorRepository extends CrudRepository<Doctor, Long> {
	
	Page<Doctor> findAll(final Pageable pageable);
	
	Doctor findByFirstnameIgnoringCase(final String firstname);
}
