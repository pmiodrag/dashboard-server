package com.twinsoft.service.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.twinsoft.domain.Doctor;

interface DoctorRepository extends CrudRepository<Doctor, Long> {
	Page<Doctor> findAll(Pageable pageable);
	Doctor findByFirstnameIgnoringCase(String firstname);
//    void delete(String id);
}
