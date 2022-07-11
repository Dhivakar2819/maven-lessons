package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.chainsys.mavenlessons.entity.Appointments;

public interface AppointmentsRepository extends CrudRepository<Appointments, Integer> {
	Appointments findById(int id);
	Appointments save(Appointments app);
	// save doctor= adding or modifying doctor
	void deleteById(int id);
	List<Appointments> findAll();
	//List<Appointments>findByDoctorId(int doc_id);
	//@Query(value="select a from Appointments a where a.docid=?1")
		// jpql - java persistent query language
		// here a is an instance of Appointments Entity
	List<Appointments> findAllByDoctorId(int doc_id);

}
