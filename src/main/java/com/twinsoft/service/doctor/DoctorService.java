package com.twinsoft.service.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.twinsoft.domain.Doctor;

public interface DoctorService {

	Page<Doctor> findAll(Pageable pageable);
	Doctor getDoctor(String firstname);
	Doctor save(Doctor Doctor);
	void deleteDoctor(String id);

}
