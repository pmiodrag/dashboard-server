package com.twinsoft.service.treatment;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.twinsoft.domain.Treatment;
import com.twinsoft.domain.TreatmentDTO;

interface TreatmentRepository extends CrudRepository<Treatment, Long> {

	Page<Treatment> findAll(Pageable pageable);
	Treatment findById(String id);
	@Query(value = "select t.treatmentdate, t.therapy, t.price, p.firstname as patientFirstname, d.firstname as doctorFirstname, dg.name as diagnoseName from treatment t "
			+ "join patient p on t.patientid=p.id "
			+ "join doctor d on t.doctorid = d.id join diagnose dg on t.diagnoseid = dg.id;", nativeQuery = true)
	List<Object[]> findAllPatientTreatments();
}

