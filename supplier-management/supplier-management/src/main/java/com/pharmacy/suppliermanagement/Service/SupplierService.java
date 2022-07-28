package com.pharmacy.suppliermanagement.Service;

import com.pharmacy.suppliermanagement.Entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    public List<Supplier> getSupplier();

    public Supplier saveSupplier(Supplier supplier);

    public Supplier updateSupplier(Supplier supplier, String id);

    public String deleteSupplier(String id);

    public Optional<Supplier> findSupplierById(String id);
}
