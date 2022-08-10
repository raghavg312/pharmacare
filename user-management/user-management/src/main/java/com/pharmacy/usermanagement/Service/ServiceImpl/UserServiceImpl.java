package com.pharmacy.usermanagement.Service.ServiceImpl;

import com.pharmacy.usermanagement.Entity.Users;
import com.pharmacy.usermanagement.Service.UserService;
import com.pharmacy.usermanagement.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<Users> getUsers() {
        List<Users> users = userRepository.findAll();
        return users;
    }

    @Override
    public Users saveUser(Users user) {
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
        Users users = userRepository.save(user);
        return users;
    }

    @Override
    public Users updateUser(Users users,String id) {
        Users u = userRepository.findById(id).get();
        u.setUserId(id);
        u.setUserPassword(users.getUserPassword());
        u.setUserContact(users.getUserContact());
        u.setUserEmail(users.getUserEmail());
        u.setUserName(users.getUserName());
        u.setUserRole(users.getUserRole());
        userRepository.save(u);
        return u;
    }

    @Override
    public String deleteUser(String id) {
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Users> findByUserId(String id) {
        List<Users> users = userRepository.findByUserId(id);
        return userRepository.findByUserId(id);
    }

}
