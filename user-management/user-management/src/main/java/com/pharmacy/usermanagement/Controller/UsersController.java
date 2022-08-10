package com.pharmacy.usermanagement.Controller;

import com.pharmacy.usermanagement.Config.EmailSenderService;
import com.pharmacy.usermanagement.Entity.Users;
import com.pharmacy.usermanagement.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSenderService senderService;

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    @GetMapping("/user")
    public ResponseEntity getUsers(){
        List<Users> a = userService.getUsers();
        if(!(a.isEmpty())){
            logger.trace("Getting all users in system");
            return ResponseEntity.ok(a);}
        else {
            logger.error("No users found in the system");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no user in the system");
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity getUsersById(@PathVariable("userId") String id){
        List<Users> a = userService.findByUserId(id);
        if(a!=null){logger.trace("Getting user with id "+id+" in the system");
            return ResponseEntity.ok(a);}
        else {
            logger.error("No user with id "+id+" in the system");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no user in the system with id "+id);
        }
    }

    @PostMapping("/user")
    public ResponseEntity createUsers(@RequestBody Users user) {
        try {
            ResponseEntity.status(HttpStatus.CREATED)
                    .body(userService.saveUser(user));
            logger.trace("Creating user");

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body( senderService.sendSimpleEmail(user.getUserEmail(),
                            "PHARMACARE: New Account Created ",
                            "Hey " + user.getUserName()+"      " +
                                    "You have created an account on Pharmacare as "+ user.getUserRole()));
        }catch (Exception e) {
            logger.error("Users not created");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Users not created. Check the inputs.");
        }
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity updateUsers(@RequestBody Users user,@PathVariable("userId") String id){

        try {
            return ResponseEntity.ok(userService.updateUser(user,id));
        }catch (Exception e) {
            logger.error("Users not updated");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Users with id "+id+" not found in the System");
        }
    }

    @DeleteMapping("/user/{userId}")
    public  ResponseEntity deleteUsers(@PathVariable("userId") String id){
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        }catch (Exception e) {
            logger.error("Users not deleted");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Users with id "+id+" not found in the System");
        }
    }
}
