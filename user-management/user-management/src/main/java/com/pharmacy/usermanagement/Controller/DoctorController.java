package com.pharmacy.usermanagement.Controller;

import com.pharmacy.usermanagement.EmailSenderService;
import com.pharmacy.usermanagement.Entity.Doctor;
import com.pharmacy.usermanagement.Service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(DoctorController.class);

    @GetMapping("/doctor")
    public ResponseEntity getDoctor(){
        List<Doctor> d = doctorService.getDoctor();
        if(!(d.isEmpty())) {
            logger.info("Getting all doctors in system");
            return ResponseEntity.ok(doctorService.getDoctor());
        }else {
            logger.error("No doctor found in the system");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no doctor in the system");
        }
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity getDoctorById(@PathVariable("doctorId") String id){
        Optional<Doctor> d = doctorService.findDoctorById(id);
        if(!(d.isEmpty())){
            logger.trace("Getting doctor with id "+id+" in the system");
            return ResponseEntity.ok(d);}
        else {logger.error("No doctor with id "+id+" in the system");
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
            logger.trace("Creating doctor");

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body( senderService.sendSimpleEmail(doctor.getDoctor_email(),
                            "PHARMACARE: New Account Created ",
                            "Hey " + doctor.getDoctor_name()+"      " +
                                    "You have created an account on Pharmacare."));
        }catch (Exception e) {
            logger.error("Doctor not created");
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
            logger.error("Doctor not updated");
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
            logger.error("Doctor not deleted");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Doctor with id "+id+" not found in the System");
        }
    }
}

