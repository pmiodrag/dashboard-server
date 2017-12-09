package com.twinsoft.service.treatment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.twinsoft.domain.Treatment;

public interface TreatmentService {

	Page<Treatment> findAll(Pageable pageable);
	Treatment save(Treatment treatment);
	void deleteTreatment(String id);

}
