package com.praveen.hms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="visiting")
public class Visiting {

	@Id
	@GeneratedValue
	private Long id;
	private Date dateTime;
	@OneToOne
	@JoinColumn(name="apid")
	private Appointment appointment;
	@ManyToOne
	@JoinColumn(name="did")
	private Doctor doctor;	
}
