package com.twinsoft.service.treatment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.twinsoft.domain.Treatment;

interface TreatmentRepository extends CrudRepository<Treatment, Long> {
	Page<Treatment> findAll(Pageable pageable);
	Treatment findById(String id);
}
