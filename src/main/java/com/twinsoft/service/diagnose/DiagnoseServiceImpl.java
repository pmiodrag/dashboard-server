package com.twinsoft.service.diagnose;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.twinsoft.domain.Diagnose;

@Component("DiagnoseService")
@Transactional
public class DiagnoseServiceImpl implements DiagnoseService {

	private final DiagnoseRepository DiagnoseRepository;
	
	public DiagnoseServiceImpl(final DiagnoseRepository DiagnoseRepository) {
		this.DiagnoseRepository = DiagnoseRepository;
	}
	
	@Override
	public Diagnose getDiagnose(String name) {
		return this.DiagnoseRepository.findByNameIgnoringCase(name);
	}

	@Override
	public Page<Diagnose> findAll(Pageable pageable) {
		return this.DiagnoseRepository.findAll(pageable);
	}

	@Override
	public void deleteDiagnose(String id) {
		this.DiagnoseRepository.delete(Long.parseLong(id));		
	}

	@Override
	public Diagnose save(Diagnose Diagnose) {
		return this.DiagnoseRepository.save(Diagnose);
	}

}
