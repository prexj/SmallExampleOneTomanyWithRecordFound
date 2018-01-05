package com.spring.model;

import java.io.Serializable;
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
@Table(name="doctor")
public class Doctor implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="FirstName")
	private String firstname;
	
	@Column(name="providedrug")
	private String provideDrug;

	@JsonIgnore
	@OneToMany(mappedBy="doctor")//,fetch=FetchType.EAGER
	private List<DrugsDoctorMapping> drugsDoctorMapping;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getProvideDrug() {
		return provideDrug;
	}

	public void setProvideDrug(String provideDrug) {
		this.provideDrug = provideDrug;
	}

	public List<DrugsDoctorMapping> getDrugsDoctorMapping() {
		return drugsDoctorMapping;
	}

	public void setDrugsDoctorMapping(List<DrugsDoctorMapping> drugsDoctorMapping) {
		this.drugsDoctorMapping = drugsDoctorMapping;
	}
	
}