package com.pharmacy.usermanagement.Service;

import com.pharmacy.usermanagement.Entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    public List<Doctor> getDoctor();

    public Doctor saveDoctor(Doctor doctor);

    public Doctor updateDoctor(Doctor doctor, String id);

    public String deleteDoctor(String id);

    public Optional<Doctor> findDoctorById(String id);

}

