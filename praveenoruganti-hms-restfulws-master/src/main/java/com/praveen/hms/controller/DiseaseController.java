package com.praveen.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.hms.dao.DiseaseDao;
import com.praveen.hms.entity.Disease;

@RestController
public class DiseaseController {

	@Autowired
	private DiseaseDao diseaseDao;
	
	@RequestMapping("/rest/diseaseInfo")
	public void diseaseInfo(@RequestBody Disease disease) {
		diseaseDao.save(disease);
	}
}
