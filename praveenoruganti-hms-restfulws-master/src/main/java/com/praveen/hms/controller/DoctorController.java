package com.praveen.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.hms.dao.DoctorDao;
import com.praveen.hms.entity.Doctor;

@RestController
public class DoctorController {

	@Autowired
	private DoctorDao doctorDao;
	
	@RequestMapping("/rest/doctorInfo")
	public void doctorInfo(@RequestBody Doctor doctor) {
		doctorDao.save(doctor);
	}
	
}
