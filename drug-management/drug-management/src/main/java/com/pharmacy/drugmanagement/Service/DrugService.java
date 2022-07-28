package com.pharmacy.drugmanagement.Service;

import com.pharmacy.drugmanagement.Entity.Drug;

import java.util.List;
import java.util.Optional;

public interface DrugService {

    public List<Drug> getDrug();

    public Drug saveDrug(Drug drug);

    public Drug updateDrug(Drug drug, String id);

    public String deleteDrug(String id);

    public Optional<Drug> findDrugById(String id);
}
