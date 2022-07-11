package com.chainsys.mavenlessons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.chainsys.mavenlessons.entity.Appointments;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.DoctorRepositories;
@RestController
public class DoctorController {
	@Autowired
	private DoctorRepositories repo;
	//@Bean
//	public void createrepo(DoctorRepositories repo) {
//		this.repo=repo;
//	}
//	@GetMapping("/getdoctor")
//	public Doctor getDoctor(int id)
//	{
//		return repo.findById(id);
//	}
	
	@GetMapping("/getdoctor")
	public String getDoctor(int id)
	{
		return repo.findById(id).toString();
	}
	@GetMapping("/getdoctorappointments")
	public String getAppointment(int id) {
		Doctor doc=repo.findById(id);
		List<Appointments> appointments=doc.getappointments();
		return appointments.toString();
	}
	
	@PostMapping(value="/adddoctor",consumes="application/json")
	// we need to give from where to read data from the HTTP request and also the content type ("application/json")
	public RedirectView adddoctor(@RequestBody Doctor dr) {
		System.out.println("Doctor : "+dr.getDoc_id()+" "+dr.getDoc_name());
		repo.save(dr);
		return new RedirectView("/getalldoctors");
	}
	@PutMapping(value="/updatedoctor",consumes="application/json")
	// we need to give from where to read data from the HTTP request and also the content type ("application/json")
	public RedirectView updatedoctor(@RequestBody Doctor dr) {
		System.out.println("Doctor : "+dr.getDoc_id()+" "+dr.getDoc_name());
		repo.save(dr);
		return new RedirectView("/getalldoctors");
	}
	@DeleteMapping("/deletedoctor")
	public RedirectView deleteDoctor(int id) {
		 repo.deleteById(id);
		 return new RedirectView("/getalldoctors");
	}
	@GetMapping("/getalldoctors")
	public List<Doctor>getDoctor(){
		return repo.findAll();
	}
}
