package com.praveen.hms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="complaint")
public class Complaint {
 
	@Id
	@GeneratedValue
	private Long id;
	@ManyToMany
	@JoinTable(
			name="complaint_disease",
			joinColumns={@JoinColumn(name="cid")},
			inverseJoinColumns={@JoinColumn(name="deid")}
	)
	private List<Disease> disease;

	private String description;
	
	@ManyToOne
	@JoinColumn(name="vid")
	private Visiting visiting;	
	
	@OneToMany(mappedBy="complaint",cascade=CascadeType.ALL)
	private List<Medication> medications;		
}
