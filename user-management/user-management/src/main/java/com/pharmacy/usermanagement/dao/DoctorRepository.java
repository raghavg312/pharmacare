package com.pharmacy.usermanagement.dao;

import com.pharmacy.usermanagement.Entity.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DoctorRepository extends CrudRepository<Doctor,String> {

public List<Doctor> findAll();
}
