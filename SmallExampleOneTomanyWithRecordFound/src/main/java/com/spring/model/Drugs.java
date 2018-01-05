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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="drugs")
public class Drugs implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="drugsname")
	private String drugsname;
	
	@Column(name="befortotal")
	private String befortotal;
	
	@Column(name="aftertotal", nullable = true)
	private String aftertotal;
	
	@JsonIgnore
	@OneToMany(mappedBy="drugs")//,fetch=FetchType.EAGER
	private List<DrugsDoctorMapping> drugsDoctorMapping;
	
	public String getBefortotal() {
		return befortotal;
	}

	public void setBefortotal(String befortotal) {
		this.befortotal = befortotal;
	}

	public String getAftertotal() {
		return aftertotal;
	}

	public void setAftertotal(String aftertotal) {
		this.aftertotal = aftertotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getDrugsname() {
		return drugsname;
	}

	public void setDrugsname(String drugsname) {
		this.drugsname = drugsname;
	}
}
