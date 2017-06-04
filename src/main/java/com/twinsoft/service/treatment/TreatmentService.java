package com.twinsoft.service.treatment;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.twinsoft.domain.Treatment;
import com.twinsoft.domain.TreatmentDTO;

public interface TreatmentService {

	Page<Treatment> findAll(Pageable pageable);
	Treatment save(Treatment treatment);
	void deleteTreatment(String id);
	List<TreatmentDTO> findAllPatientTreatments();

}
