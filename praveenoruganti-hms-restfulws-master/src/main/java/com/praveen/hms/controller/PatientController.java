package com.praveen.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.hms.entity.Patient;
import com.praveen.hms.service.PatientService;

@RestController
@RequestMapping("/rest/patientInfo")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping
	public void patientInfo(@RequestBody Patient patient) {
	//	patient.setDate(new Date());
		patientService.patientInfo(patient);
	}
	
	@PostMapping("/all")
	public void allPatientInfo(@RequestBody List<Patient> patients) {
		patientService.allPatientInfo(patients);
	}
	
	@GetMapping("/byMedicine/{name}")
	public List<Object[]> getPatientByMedicineName(@PathVariable("name") String medicineName) {
		return patientService.getPatientByMedicineName(medicineName);
		
	}
	
}
