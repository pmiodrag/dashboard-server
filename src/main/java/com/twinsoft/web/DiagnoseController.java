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

import com.twinsoft.domain.Diagnose;
import com.twinsoft.service.diagnose.DiagnoseService;

/**
 * @author miodrag
 *
 */
@RestController
@RequestMapping("/api/diagnoses")
public class DiagnoseController {
	
	@Autowired
	private DiagnoseService diagnoseService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<Diagnose> getDiagnoses(final Pageable pageable) {
		return this.diagnoseService.findAll(pageable);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable final String id) {
		this.diagnoseService.deleteDiagnose(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Diagnose create(@RequestBody final Diagnose diagnose) {
	    return this.diagnoseService.save(diagnose);
	}

}
