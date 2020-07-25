package com.praveen.hms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="medication")
public class Medication {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="mid")
	private Medicine medicne;
	private String howtoUse;
	private Integer quantity;
	private Integer duration;

	@ManyToOne
	@JoinColumn(name="cid")
	private Complaint complaint;		
}
