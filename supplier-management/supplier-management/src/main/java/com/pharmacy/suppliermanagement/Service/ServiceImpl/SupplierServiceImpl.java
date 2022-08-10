package com.pharmacy.suppliermanagement.Service.ServiceImpl;

import com.pharmacy.suppliermanagement.Entity.Supplier;
import com.pharmacy.suppliermanagement.Service.SupplierService;
import com.pharmacy.suppliermanagement.dao.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getSupplier() {
        List<Supplier> supplier = supplierRepository.findAll();
        return supplier;
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        Supplier suppliers = supplierRepository.save(supplier);
        return suppliers;
    }

    @Override
    public Supplier updateSupplier(Supplier supplier, String id) {
        Supplier s = supplierRepository.findById(id).get();
        s.setSupplierId(id);
        s.setSupplierName(supplier.getSupplierName());
        s.setSupplierContact(supplier.getSupplierContact());
        s.setSupplierEmail(supplier.getSupplierEmail());
        supplierRepository.save(s);
        return s;
    }

    @Override
    public String deleteSupplier(String id) {
        supplierRepository.deleteById(id);
        return id;
    }

    public List<Supplier> findSupplierById(String id){
        List<Supplier> s = supplierRepository.findSupplierById(id);
        return s;
    }
}