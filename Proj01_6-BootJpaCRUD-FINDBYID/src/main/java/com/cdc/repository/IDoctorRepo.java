package com.cdc.repository;

import org.springframework.data.repository.CrudRepository;

import com.cdc.entity.Doctor;

public interface IDoctorRepo extends CrudRepository<Doctor, Integer> {

}
