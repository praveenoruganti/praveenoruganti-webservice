package com.praveen.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.hms.entity.Doctor;
@Repository
public interface DoctorDao extends JpaRepository<Doctor, Long> {

}
