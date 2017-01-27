package com.twinsoft.service.diagnose;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.twinsoft.domain.Diagnose;

interface DiagnoseRepository extends CrudRepository<Diagnose, Long> {
	
	Page<Diagnose> findAll(final Pageable pageable);
	
	Diagnose findByNameIgnoringCase(final String name);
}
