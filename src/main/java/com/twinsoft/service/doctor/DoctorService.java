package com.twinsoft.service.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.twinsoft.domain.Doctor;

public interface DoctorService {

	Page<Doctor> findAll(Pageable pageable);
	
	Doctor getDoctor(final String firstname);
	
	Doctor save(final Doctor doctor);
	
	void deleteDoctor(final String id);

}
