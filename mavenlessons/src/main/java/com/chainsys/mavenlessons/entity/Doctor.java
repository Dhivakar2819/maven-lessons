package com.chainsys.mavenlessons.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;
@Entity
@Table(name="Doctor")
public class Doctor {
	@Id
	@Column(name="DOC_ID")
	private int id;
	private String doc_name;
	private Date dob;
	private String speciality;
	private String city;
	private long phone_no;
	@Column(name="fees")
	private float fees;
	
	@OneToMany(mappedBy="doctor",fetch=FetchType.LAZY)
	
	private List<Appointments>appointments;
	public List<Appointments> getappointments(){
		return this.appointments;
	}
	
	public int getDoc_id() {
		return id;
	}
	public void setDoc_id(int doc_id) {
		this.id = doc_id;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return String.format("%d, %s, %s, %s, %s",id,doc_name,dob,city,phone_no);
	}
	
	
}
