package com.twinsoft.service.treatment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.twinsoft.domain.Treatment;

public interface TreatmentService {

	Page<Treatment> findAll(final Pageable pageable);
	
	Treatment getTreatment(final Long id);
	
	Treatment save(final Treatment treatment);
	
	void deleteTreatment(final String id);

}
