package com.twinsoft.service.doctor;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.twinsoft.domain.Doctor;

@Component("DoctorService")
@Transactional
public class DoctorServiceImpl implements DoctorService {

	private final DoctorRepository DoctorRepository;
	
	public DoctorServiceImpl(final DoctorRepository DoctorRepository) {
		this.DoctorRepository = DoctorRepository;
	}
	
	@Override
	public Doctor getDoctor(String firstname) {
		return this.DoctorRepository.findByFirstnameIgnoringCase(firstname);
	}

	@Override
	public Page<Doctor> findAll(Pageable pageable) {
		return this.DoctorRepository.findAll(pageable);
	}

	@Override
	public void deleteDoctor(String id) {
		this.DoctorRepository.delete(Long.parseLong(id));		
	}

	@Override
	public Doctor save(Doctor Doctor) {
		return this.DoctorRepository.save(Doctor);
	}

}
