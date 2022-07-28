package com.pharmacy.usermanagement.Controller;

import com.pharmacy.usermanagement.EmailSenderService;
import com.pharmacy.usermanagement.Entity.Doctor;
import com.pharmacy.usermanagement.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private EmailSenderService senderService;

    @GetMapping("/doctor")
    public ResponseEntity getDoctor(){
        List<Doctor> d = doctorService.getDoctor();
        if(!(d.isEmpty())) {
            return ResponseEntity.ok(doctorService.getDoctor());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no doctor in the system");
        }
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity getDoctorById(@PathVariable("doctorId") String id){
        Optional<Doctor> d = doctorService.findDoctorById(id);
        if(!(d.isEmpty()))
            return ResponseEntity.ok(d);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no doctor in the system with id "+id);
        }
    }

    @PostMapping("/doctor")
    public ResponseEntity createDoctor(@RequestBody Doctor doctor) {
        // return ResponseEntity.ok(doctorService.saveDoctor(doctor));

        try {
            ResponseEntity.status(HttpStatus.CREATED)
                    .body(doctorService.saveDoctor(doctor));

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body( senderService.sendSimpleEmail(doctor.getDoctor_email(),
                            "PHARMACARE: New Account Created ",
                            "Hey " + doctor.getDoctor_name()+"      " +
                                    "You have created an account on Pharmacare."));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Admin not created. Check the inputs.");
        }
    }

    @PutMapping("/doctor/{doctorId}")
    public ResponseEntity updateDoctor(@RequestBody Doctor doctor,@PathVariable("doctorId") String id){

        try {
            return ResponseEntity.ok(doctorService.updateDoctor(doctor,id));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Doctor with id "+id+" not found in the System");
        }
    }

    @DeleteMapping("/doctor/{doctorId}")
    public  ResponseEntity deleteDoctor(@PathVariable("doctorId") String id){
        try {
            return ResponseEntity.ok(doctorService.deleteDoctor(id));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Doctor with id "+id+" not found in the System");
        }
    }
}

