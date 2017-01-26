package com.twinsoft.service.diagnose;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.twinsoft.domain.Diagnose;

interface DiagnoseRepository extends CrudRepository<Diagnose, Long> {
	Page<Diagnose> findAll(Pageable pageable);
	Diagnose findByNameIgnoringCase(String name);
}
