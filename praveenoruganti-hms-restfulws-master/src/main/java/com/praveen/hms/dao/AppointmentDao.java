package com.praveen.hms.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.praveen.hms.entity.Appointment;
@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long> {

@Query("select a.id , a.primaryReason , p.name, p.date, p.phone from Appointment a "
			+ "join a.patient p "
			+ "where a.dateTime=?1")
	public List<Object[]> getAppointAndPatientByDate(Date date);
	
}
