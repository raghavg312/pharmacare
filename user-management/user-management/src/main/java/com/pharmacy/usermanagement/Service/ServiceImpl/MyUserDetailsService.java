package com.pharmacy.usermanagement.Service.ServiceImpl;

import com.pharmacy.usermanagement.Entity.MyUserDetails;
import com.pharmacy.usermanagement.Entity.Users;
import com.pharmacy.usermanagement.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUserEmail(username);
        if(users != null){
            return new MyUserDetails(users);
        }else{
            throw new UsernameNotFoundException("Not found - "+username);
        }
    }
}
