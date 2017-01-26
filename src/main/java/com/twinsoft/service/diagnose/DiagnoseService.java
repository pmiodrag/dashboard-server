package com.twinsoft.service.diagnose;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.twinsoft.domain.Diagnose;

public interface DiagnoseService {

	Page<Diagnose> findAll(Pageable pageable);
	Diagnose getDiagnose(String name);
	Diagnose save(Diagnose Diagnose);
	void deleteDiagnose(String id);

}
