package com.praveen.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.hms.dao.VisitingDao;
import com.praveen.hms.entity.Visiting;

@Service
public class VisitingService {

	@Autowired
	private VisitingDao visitingDao;

//==================================================
	//Save details
	
	public void saveVisiting(Visiting visiting) {
		visitingDao.save(visiting);
	}
	
	public void saveAllVisiting(List<Visiting> visitings) {
		visitingDao.saveAll(visitings);
	}
//=============================================================
	//Get Data Details
	
	public List<String> getPatientByDoctorName(String doctorName) {
		return visitingDao.getPatientByDoctorName(doctorName);
	}
	
	
	public List<String> getDoctorByPatientName(String patientName) {
		return visitingDao.getDoctorByPatientName(patientName);
	}
	
	
}
