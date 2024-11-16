package com.cdc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdc.entity.Doctor;
import com.cdc.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService {
	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public String registerDoctor(Doctor doctor) {
		Doctor doc = doctorRepo.save(doctor);
		return "Doctor Object is saved with object ID" + doc.getDocId();
	}

	/*
	 * @Override public String registerGroupOfDoctors(Iterable<Doctor> doctors) { if
	 * (doctors != null) { Iterable<Doctor> savedDoctors =
	 * doctorRepo.saveAll(doctors); int size = ((Collection) savedDoctors).size();
	 * List<Integer> ids = (List<Integer>) ((Collection)
	 * savedDoctors).stream().map(d -> ((Doctor) d).getDocId())
	 * .collect(Collectors.toList()); return size +
	 * "Number of doctors are saved with ID values: " + ids.toString(); } else {
	 * throw new IllegalArgumentException("Invalid Doctors Info"); }
	 * 
	 * }
	 */
	@Override
	public String registerGroupOfDoctors(Iterable<Doctor> doctors) {
		if (doctors != null) {
			Iterable<Doctor> savedDoctors = doctorRepo.saveAll(doctors);
			int size = ((Collection) savedDoctors).size();
			List<Integer> ids = new ArrayList();
			savedDoctors.forEach(d -> {
				ids.add(d.getDocId());
			});
			return size + "Number of doctors are saved with ID values: " + ids.toString();
		} else {
			throw new IllegalArgumentException("Invalid Doctors Info");
		}

	}

	@Override
	public boolean isCustomerAvailable(Integer id) {
		boolean flag = doctorRepo.existsById(id);
		return flag;
	}

	@Override
	public long fetchDoctorsCount() {
		return doctorRepo.count();
	}

	@Override
	public Iterable<Doctor> showAllDoctors() {

		return doctorRepo.findAll();
	}

	@Override
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids) {

		return doctorRepo.findAllById(ids);
	}
//FINDBYID
	/*@Override
	public Doctor showDoctorById(Integer id) {
		Optional<Doctor> opt = doctorRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new IllegalArgumentException("Invalid Doctor Id");
		}*/

	@Override
	public Doctor showDoctorById(Integer id) {
		Doctor doctor = doctorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Doctor Id"));
		return doctor;
	}

}
