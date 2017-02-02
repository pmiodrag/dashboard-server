/**
 * 
 */
package com.twinsoft.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.twinsoft.domain.Treatment;
import com.twinsoft.service.treatment.TreatmentService;

/**
 * @author miodrag
 *
 */
@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {
	
	@Autowired
	private TreatmentService treatmentService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Treatment> getTreatments(final Pageable pageable) {
		return this.treatmentService.findAll(pageable);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable final String id) {
		this.treatmentService.deleteTreatment(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Treatment create(@RequestBody final Treatment treatment) {
	    return this.treatmentService.save(treatment);
	}

}
