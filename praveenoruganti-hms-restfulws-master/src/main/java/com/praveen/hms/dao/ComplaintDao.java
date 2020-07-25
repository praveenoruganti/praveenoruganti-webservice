package com.praveen.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.praveen.hms.entity.Complaint;

@Repository
public interface ComplaintDao extends JpaRepository<Complaint, Long> {

	@Query("select p.name from Complaint c "
			+ "join c.disease di "
			+ "join c.visiting v "
			+ "join v.appointment a "
			+ "join a.patient p "
			+ "where di.name=?1")
	public List<String> getPatientByDiseaseName(String diseaseName);
	
}
