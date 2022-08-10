package com.pharmacy.suppliermanagement.dao;

import com.pharmacy.suppliermanagement.Entity.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupplierRepository  extends CrudRepository<Supplier,String> {

    public List<Supplier> findAll();
    public List<Supplier> findSupplierById(String id);
}
