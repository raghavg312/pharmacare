package com.pharmacy.drugmanagement.Service;

import com.pharmacy.drugmanagement.Entity.Drug;

import java.util.List;

public interface DrugService {

    public List<Drug> getDrug();

    public Drug saveDrug(Drug drug);

    public Drug updateDrug(Drug drug, String id);

    public String deleteDrug(String id);

    public List<Drug> findDrugById(String id);
    public Drug updateDrugQuantity(Drug drug, String id);
}
