package com.praveen.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.hms.entity.Complaint;
import com.praveen.hms.service.ComplaintService;

@RestController
@RequestMapping("/rest/complaint")
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;	


	@PostMapping
	public void saveComplaint(@RequestBody Complaint complaint) {
		complaintService.saveComplaint(complaint);
	}
	
	@PostMapping("/all")
	public void saveAllComplaint(@RequestBody List<Complaint> complaints) {
		complaintService.saveAllComplaint(complaints);
	}	
	
	@GetMapping("/byDisease/{name}")
	public List<String> getPatientByDiseaseName(@PathVariable("name") String diseaseName) {
		return complaintService.getPatientByDiseaseName(diseaseName);
	}
	
	
}
