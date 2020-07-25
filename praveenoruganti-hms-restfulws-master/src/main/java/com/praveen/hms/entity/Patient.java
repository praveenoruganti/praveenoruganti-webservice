package com.praveen.hms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Date date;
	private Long phone;
}
