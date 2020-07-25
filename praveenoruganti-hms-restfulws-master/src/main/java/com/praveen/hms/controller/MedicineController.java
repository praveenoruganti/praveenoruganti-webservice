package com.praveen.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.hms.dao.MedicineDao;
import com.praveen.hms.entity.Medicine;

@RestController
public class MedicineController {

	@Autowired
	private MedicineDao medicineDao;
	
	@RequestMapping("/rest/medicineInfo")
	public void medicineInfo(@RequestBody Medicine medicine) {
		medicineDao.save(medicine);
	}
}
