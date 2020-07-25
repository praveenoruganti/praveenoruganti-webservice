package com.praveen.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.hms.entity.Disease;

@Repository
public interface DiseaseDao extends JpaRepository<Disease,Long> {

}
