package com.twinsoft.service.treatment;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.twinsoft.domain.Treatment;

@Component("TreatmentService")
@Transactional
public class TreatmentServiceImpl implements TreatmentService {

	private final TreatmentRepository treatmentRepository;
	
	public TreatmentServiceImpl(final TreatmentRepository treatmentRepository) {
		this.treatmentRepository = treatmentRepository;
	}
	
	@Override
	public Treatment getTreatment(final Long id) {
		return this.treatmentRepository.findById(id);
	}

	@Override
	public Page<Treatment> findAll(final Pageable pageable) {
		return this.treatmentRepository.findAll(pageable);
	}

	@Override
	public void deleteTreatment(final String id) {
		this.treatmentRepository.delete(Long.parseLong(id));		
	}

	@Override
	public Treatment save(final Treatment treatment) {
		return this.treatmentRepository.save(treatment);
	}

}
