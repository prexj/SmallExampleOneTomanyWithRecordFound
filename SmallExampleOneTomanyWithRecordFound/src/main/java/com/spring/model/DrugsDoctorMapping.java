package com.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="DrugsDoctorMapping")
public class DrugsDoctorMapping implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne()//fetch=FetchType.EAGER
	@JoinColumn(name="drug_id",nullable = true)
	private Drugs drugs;
	
	@ManyToOne()//fetch=FetchType.EAGER
	@JoinColumn(name="doct_id",nullable = true)
	private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Drugs getDrugs() {
		return drugs;
	}

	public void setDrugs(Drugs drugs) {
		this.drugs = drugs;
	}
	

}
