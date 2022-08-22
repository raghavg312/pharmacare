package com.pharmacy.usermanagement.Service;

import com.pharmacy.usermanagement.Entity.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {


    public List<Users> getUsers();

    public Users saveUser(Users users);

    public Users updateUser(Users users, String id);

    public String deleteUser(String id);

    Users findByUserId(String id);

    public Users findByUserEmail(String email);
}
