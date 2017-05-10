/**
 * 
 */
package com.twinsoft.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twinsoft.domain.Patient;
import com.twinsoft.service.patient.PatientService;

/**
 * @author miodrag
 *
 */
@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Patient> getPatients(Pageable pageable) {
		return this.patientService.findAll(pageable);
	}
		

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable String id) {
		this.patientService.deletePatient(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Patient create(@RequestBody Patient patient) {
	    return this.patientService.save(patient);
	}

}
