package com.twinsoft.service.treatment;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.twinsoft.domain.Doctor;
import com.twinsoft.domain.Treatment;
import com.twinsoft.domain.TreatmentDTO;

@Component("treatmentService")
@Transactional
public class TreatmentServiceImpl implements TreatmentService {

	private final TreatmentRepository treatmentRepository;
	
	public TreatmentServiceImpl(final TreatmentRepository TreatmentRepository) {
		this.treatmentRepository = TreatmentRepository;
	}

	@Override
	public Page<Treatment> findAll(Pageable pageable) {
		return this.treatmentRepository.findAll(pageable);
	}

	@Override
	public Treatment save(Treatment treatment) {
		return this.treatmentRepository.save(treatment);
	}

	@Override
	public void deleteTreatment(String id) {
		this.treatmentRepository.delete(Long.parseLong(id));
		
	}
	
	@Override
	public List<TreatmentDTO> findAllPatientTreatments() {
		List<Object[]> patientTreatments = this.treatmentRepository.findAllPatientTreatments();
		List<TreatmentDTO> treatmentDtoList =
				patientTreatments.stream()
			                .map(TreatmentDTO::new)
			                .collect(Collectors.toList());
		return treatmentDtoList;
	}
	

}
