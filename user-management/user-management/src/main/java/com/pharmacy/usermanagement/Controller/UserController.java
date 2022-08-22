package com.pharmacy.usermanagement.Controller;

import com.pharmacy.usermanagement.Config.EmailSenderService;
import com.pharmacy.usermanagement.Entity.LoginModel;
import com.pharmacy.usermanagement.Entity.Users;
import com.pharmacy.usermanagement.Service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;
    Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping("/user/login")
    public ResponseEntity<?> checkUserLogin(@RequestBody LoginModel authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        return ResponseEntity.ok(userDetails);
    }

    @GetMapping("/user")
    @ApiOperation(value = "get all users")
    public ResponseEntity<List<Users>> getUsers(){
        try {
            return ResponseEntity.ok(userService.getUsers());
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/id/{userId}")
    @ApiOperation(value = "get user by user id")
    public ResponseEntity getUsersById(@PathVariable("userId") String id){
        Users a = userService.findByUserId(id);
        if(a!=null){
            logger.trace("Getting user with id "+id+" in the system");
            return ResponseEntity.ok(a);
        }
        else {
            logger.error("No user with id "+id+" in the system");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no user in the system with id "+id);
        }
    }

    @GetMapping("/user/email/{email}")
    @ApiOperation(value = "get user by email")
    public ResponseEntity getUsersByUserEmail(@PathVariable("email") String email){
        Users a = userService.findByUserEmail(email);
        if(a!=null){
            logger.trace("Getting user with email "+email+" in the system");
            return ResponseEntity.ok(a);
        }
        else {
            logger.error("No user with email "+email+" in the system");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no user in the system with email "+email);
        }
    }


    @PostMapping("/createUser")
    @ApiOperation(value = "adding new user ",notes = "Provide the required details to register as a user",response = Users.class)
    public ResponseEntity createUser(@RequestBody Users users) {
        try {
            ResponseEntity.status(HttpStatus.CREATED)
                    .body(userService.saveUser(users));
            logger.trace("Creating user");
            return ResponseEntity.status(HttpStatus.CREATED).body(users);
//                    .body( emailSenderService.sendSimpleEmail(users.getUserEmail(),
//                            "PHARMACARE: New Account Created ",
//                            "Hey " + users.getUserName() +"      " +
//                                    "You have created an account on Pharmacare as "+ users.getUserRole() +"."));
        }catch (Exception e) {
            logger.error("Users not created");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User not created. Check the inputs.");
        }
    }

    @PutMapping("/user/{userId}")
    @ApiOperation(value = "update user details",notes = "Provide the updated details with correct id",response = Users.class)
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
    @ApiOperation(value = "Deletion of user",notes = "Provide the user id for deleting the user")
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