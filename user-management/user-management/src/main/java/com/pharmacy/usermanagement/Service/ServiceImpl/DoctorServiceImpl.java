package com.pharmacy.usermanagement.Service.ServiceImpl;


import com.pharmacy.usermanagement.Entity.Doctor;
import com.pharmacy.usermanagement.Service.DoctorService;
import com.pharmacy.usermanagement.dao.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getDoctor() {
        List<Doctor> doctor = doctorRepository.findAll();
        return doctor;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        Doctor doctors = doctorRepository.save(doctor);
        return doctors;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor,String id) {

        Doctor a = doctorRepository.findById(id).get();
        a.setDoctorId(id);
        a.setDoctorPassword(doctor.getDoctorPassword());
        a.setDoctorContact(doctor.getDoctorContact());
        a.setDoctorEmail(doctor.getDoctorEmail());
        a.setDoctorName(doctor.getDoctorName());
        doctorRepository.save(a);
        return a;
    }

    @Override
    public String deleteDoctor(String id) {
        doctorRepository.deleteById(id);
        return id;
    }

    public Optional<Doctor> findDoctorById(String id){
        Optional<Doctor> a = doctorRepository.findById(id);
        return a;
    }
}
