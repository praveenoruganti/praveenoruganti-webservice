package com.praveen.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.hms.entity.Medication;

@Repository
public interface MedicationDao extends JpaRepository<Medication, Long> {

}
