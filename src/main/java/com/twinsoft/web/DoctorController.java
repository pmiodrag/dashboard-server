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

import com.twinsoft.domain.Doctor;
import com.twinsoft.service.doctor.DoctorService;

/**
 * @author miodrag
 *
 */
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Doctor> getDoctors(final Pageable pageable) {
		return this.doctorService.findAll(pageable);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable final String id) {
		this.doctorService.deleteDoctor(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Doctor create(@RequestBody final Doctor doctor) {
	    return this.doctorService.save(doctor);
	}

}
