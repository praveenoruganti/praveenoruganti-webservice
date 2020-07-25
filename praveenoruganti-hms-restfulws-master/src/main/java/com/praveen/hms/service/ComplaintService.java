package com.praveen.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.hms.dao.ComplaintDao;
import com.praveen.hms.entity.Complaint;
import com.praveen.hms.entity.Medication;

@Service
public class ComplaintService {

	@Autowired
	private ComplaintDao complaintDao;
//=======================================================================
	//Save Details
	
	public void saveComplaint(Complaint complaint) {
		
		List<Medication> medicationslist = complaint.getMedications();
	
		for (Medication medication : medicationslist) {
		        medication.setComplaint(complaint);
		}
		complaintDao.save(complaint);
	}
	
	public void saveAllComplaint(List<Complaint> complaints) {
		for (Complaint complaint2 : complaints) {
			
		        List<Medication> medicationslist = complaint2.getMedications();
		
	                    	for (Medication medication : medicationslist) {
		                            medication.setComplaint(complaint2);
		          }
	         }
		complaintDao.saveAll(complaints);
	}
//=============================================================================
	//Get Data details
	
	public List<String> getPatientByDiseaseName(String diseaseName) {
		return complaintDao.getPatientByDiseaseName(diseaseName);
	}
	
	
	
	
	
	
	
	
	
}
