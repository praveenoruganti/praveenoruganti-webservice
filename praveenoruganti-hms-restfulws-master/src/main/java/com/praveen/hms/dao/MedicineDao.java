package com.praveen.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.hms.entity.Medicine;

@Repository
public interface MedicineDao extends JpaRepository<Medicine, Long> {

}
