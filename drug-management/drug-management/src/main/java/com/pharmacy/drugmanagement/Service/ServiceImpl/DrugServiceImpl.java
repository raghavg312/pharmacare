package com.pharmacy.drugmanagement.Service.ServiceImpl;


import com.pharmacy.drugmanagement.Entity.Drug;
import com.pharmacy.drugmanagement.Service.DrugService;
import com.pharmacy.drugmanagement.dao.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugRepository drugRepository;

    @Override
    public List<Drug> getDrug() {
        List<Drug> drug = drugRepository.findAll();
        return drug;
    }

    @Override
    public Drug saveDrug(Drug drug) {
        Drug drugs = drugRepository.save(drug);
        return drugs;
    }

    @Override
    public Drug updateDrug(Drug drug,String id) {
        Drug d = drugRepository.findById(id).get();
        d.setDrugId(id);
        d.setDrugName(drug.getDrugName());
        d.setDrugQuantity(drug.getDrugQuantity());
        d.setBatchId(drug.getBatchId());
        d.setPrice(drug.getPrice());
        d.setExpiryDate(drug.getExpiryDate());
        drugRepository.save(d);
        return d;
    }

    @Override
    public String deleteDrug(String id) {
        drugRepository.deleteById(id);
        return id;
    }

    public Optional<Drug> findDrugById(String id){
        Optional<Drug> a = drugRepository.findById(id);
        return a;
    }
}
