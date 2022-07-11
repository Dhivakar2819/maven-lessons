package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Appointments")
public class Appointments {
	@Id
	@Column(name="APP_ID")
	private int id;
	@Column(name="APP_DATE")
	private Date Appdate;
	@Column(name="DOC_ID")
	private int docid;
	@Column(name="PATIENT_NAME")
	private String patient_name;
	@Column(name="FEES_COLLECTED")
	private float  feescollected;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DOC_ID",nullable=false,insertable=false,updatable=false)
	@JsonIgnore
	private Doctor doctor;
	public Doctor getDoctor() {
		return this.doctor;
	}
	public void setDoctor(Doctor doc) {
		this.doctor=doc;
	}
	
	public int getApp_id() {
		return id;
	}
	public void setApp_id(int app_id) {
		this.id = app_id;
	}
	public Date getAppdate() {
		return Appdate;
	}
	public void setAppdate(Date appdate) {
		Appdate = appdate;
	}
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public float getFeescollected() {
		return feescollected;
	}
	public void setFeescollected(float feescollected) {
		this.feescollected = feescollected;
	}
	@Override
	public String toString() {
		return String.format("%d,%s,%s,%.2f",id,Appdate,patient_name,feescollected);
	}
	
}
