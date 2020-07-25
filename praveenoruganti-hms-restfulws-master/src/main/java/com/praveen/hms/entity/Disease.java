package com.praveen.hms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="disease")
public class Disease {

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String name;	
}
