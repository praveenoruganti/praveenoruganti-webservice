package com.praveen.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.praveen.hms.entity.Patient;
@Repository
public interface PatientDao extends JpaRepository<Patient , Long> {

	@Query("select  p.name , di.name , d.name from Medication m "
			+ "join m.medicne me "
			+ "join m.complaint c "
			+ "join c.disease di "
			+ "join c.visiting v "
			+ "join v.appointment a "
			+ "join v.doctor d "
			+ "join a.patient p "
			+ "where me.name=?1")
	public List<Object[]> getPatientByMedicineName(String medicineName);
}
