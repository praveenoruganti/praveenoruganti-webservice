package com.praveen.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.hms.dao.MedicationDao;
import com.praveen.hms.entity.Medication;

@Service
public class MedicationService {

	@Autowired
	private MedicationDao medicationDao;
	
	public void saveMedication(Medication medication) {
		medicationDao.save(medication);
	}
	
	public void saveAllMedication(List<Medication> medications) {
		medicationDao.saveAll(medications);
	}
}
