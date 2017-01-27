package com.twinsoft.service.doctor;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.twinsoft.domain.Doctor;

@Component("DoctorService")
@Transactional
public class DoctorServiceImpl implements DoctorService {

	private final DoctorRepository doctorRepository;
	
	public DoctorServiceImpl(final DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	@Override
	public Doctor getDoctor(final String firstname) {
		return this.doctorRepository.findByFirstnameIgnoringCase(firstname);
	}

	@Override
	public Page<Doctor> findAll(final Pageable pageable) {
		return this.doctorRepository.findAll(pageable);
	}

	@Override
	public void deleteDoctor(final String id) {
		this.doctorRepository.delete(Long.parseLong(id));		
	}

	@Override
	public Doctor save(final Doctor doctor) {
		return this.doctorRepository.save(doctor);
	}

}
