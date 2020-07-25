package com.praveen.hms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="appointment")
public class Appointment {

	@Id
	@GeneratedValue
	private Long id;
	private Date dateTime;
	private String primaryReason;

	@ManyToOne
	@JoinColumn(name="pid")
	private Patient patient;		
}
