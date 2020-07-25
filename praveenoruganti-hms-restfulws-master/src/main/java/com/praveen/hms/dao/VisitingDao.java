package com.praveen.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.praveen.hms.entity.Visiting;

@Repository
public interface VisitingDao extends JpaRepository<Visiting, Long> {

	@Query("select p.name from Visiting v "
			+ "join v.doctor d "
			+ "join v.appointment a "
			+ "join a.patient p "
			+ "where d.name=?1")
	public List<String> getPatientByDoctorName(String doctorName);



	@Query("select d.name from Visiting v "
			+ "join v.doctor d "
			+ "join v.appointment a "
			+ "join a.patient p "
			+ "where p.name=?1")
	public List<String> getDoctorByPatientName(String patientName);



}

