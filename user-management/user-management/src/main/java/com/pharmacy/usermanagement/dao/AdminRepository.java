package com.pharmacy.usermanagement.dao;

import com.pharmacy.usermanagement.Entity.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<Admin,String> {

    public List<Admin> findAll();
}
