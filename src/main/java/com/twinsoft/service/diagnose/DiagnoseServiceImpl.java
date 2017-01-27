package com.twinsoft.service.diagnose;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.twinsoft.domain.Diagnose;

@Component("DiagnoseService")
@Transactional
public class DiagnoseServiceImpl implements DiagnoseService {

	private final DiagnoseRepository diagnoseRepository;
	
	public DiagnoseServiceImpl(final DiagnoseRepository diagnoseRepository) {
		this.diagnoseRepository = diagnoseRepository;
	}
	
	@Override
	public Diagnose getDiagnose(final String name) {
		return this.diagnoseRepository.findByNameIgnoringCase(name);
	}

	@Override
	public Page<Diagnose> findAll(final Pageable pageable) {
		return this.diagnoseRepository.findAll(pageable);
	}

	@Override
	public void deleteDiagnose(final String id) {
		this.diagnoseRepository.delete(Long.parseLong(id));		
	}

	@Override
	public Diagnose save(final Diagnose diagnose) {
		return this.diagnoseRepository.save(diagnose);
	}

}
