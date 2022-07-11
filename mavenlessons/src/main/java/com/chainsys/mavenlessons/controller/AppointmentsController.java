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
import com.chainsys.mavenlessons.repository.AppointmentsRepository;

@RestController
public class AppointmentsController {
	@Autowired
	private AppointmentsRepository arepo;
	@GetMapping(value="/fetchdoctorbyappointmentid")
	public String getDoctorBtAppointmentId(int id) {
		Appointments app=arepo.findById(id);
		Doctor doc=app.getDoctor();
		return doc.toString();
	}

	// @Bean
//		public void createrepo(AppointmentsRepositories repo) {
//			this.repo=repo;
//		}
	@GetMapping("/getappointments")
	public Appointments getAppointments(int id) {
		return arepo.findById(id);
	}
	
//	@GetMapping("/fetchappointmentbydoctor")
//	public List<Appointments> getAppointmentByDocId(int id) {
//		return arepo.findAllByDoctorId(id);
//	}

	@PostMapping(value = "/addappointments", consumes = "application/json")
	// we need to give from where to read data from the HTTP request and also the
	// content type ("application/json")
	public RedirectView addAppointments(@RequestBody Appointments app) {
		System.out.println("Appointments : " + app.getApp_id() + " " + app.getPatient_name());
		arepo.save(app);
		return new RedirectView("/getallappointments");
	}

	@PutMapping(value = "/updateappointments", consumes = "application/json")
	// we need to give from where to read data from the HTTP request and also the
	// content type ("application/json")
	public RedirectView updateAppointments(@RequestBody Appointments app) {
		System.out.println("Appointments : " + app.getApp_id() + " " + app.getPatient_name());
		arepo.save(app);
		return new RedirectView("/getallappointments");
	}

	@DeleteMapping("/deleteappointments")
	public RedirectView deleteAppointments(int id) {
		arepo.deleteById(id);
		return new RedirectView("/getallappointments");
	}

	@GetMapping("/getallappointments")
	public List<Appointments> getAppointments() {
		return arepo.findAll();

	}
	@GetMapping("/getallbydocid")
	public List<Appointments> getallbydocid(int doc_id) {
		return arepo.findAllByDoctorId(doc_id);

	}

}
