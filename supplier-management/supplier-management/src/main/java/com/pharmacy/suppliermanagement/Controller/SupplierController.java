package com.pharmacy.suppliermanagement.Controller;

import com.pharmacy.suppliermanagement.Entity.Supplier;
import com.pharmacy.suppliermanagement.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/supplier")
    public ResponseEntity getSupplier(){
        List<Supplier> a = supplierService.getSupplier();
        if(!(a.isEmpty()))
            return ResponseEntity.ok(a);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no supplier in the system");
        }
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity getSupplierById(@PathVariable("supplierId") String id){
        Optional<Supplier> a = supplierService.findSupplierById(id);
        if(!(a.isEmpty()))
            return ResponseEntity.ok(a);
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no supplier in the system with id "+id);
        }
    }

    @PostMapping("/supplier")
    public ResponseEntity createSupplier(@RequestBody Supplier supplier) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(supplierService.saveSupplier(supplier));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Supplier not created. Check the inputs.");
        }
    }

    @PutMapping("/supplier/{supplierId}")
    public ResponseEntity updateSupplier(@RequestBody Supplier supplier,@PathVariable("supplierId") String id){

        try {
            return ResponseEntity.ok(supplierService.updateSupplier(supplier,id));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Supplier with id "+id+" not found in the System");
        }
    }

    @DeleteMapping("/supplier/{supplierId}")
    public  ResponseEntity deleteSupplier(@PathVariable("supplierId") String id){
        try {
            return ResponseEntity.ok(supplierService.deleteSupplier(id));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Supplier with id "+id+" not found in the System");
        }
    }
}

