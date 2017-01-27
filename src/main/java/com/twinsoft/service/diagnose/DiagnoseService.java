package com.twinsoft.service.diagnose;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.twinsoft.domain.Diagnose;

public interface DiagnoseService {

	Page<Diagnose> findAll(final Pageable pageable);
	
	Diagnose getDiagnose(final String name);
	
	Diagnose save(final Diagnose diagnose);
	
	void deleteDiagnose(final String id);

}
