package com.pharmacy.suppliermanagement.Controller;

import com.pharmacy.suppliermanagement.Entity.Supplier;
import com.pharmacy.suppliermanagement.Service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @GetMapping("/supplier")
    public ResponseEntity getSupplier(){
        List<Supplier> a = supplierService.getSupplier();
        if(!(a.isEmpty()))
        {
            logger.info("Getting all supplier in system");
            return ResponseEntity.ok(a);}
        else {logger.error("No supplier found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no supplier in the system");
        }
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity getSupplierById(@PathVariable("supplierId") String id){
        try {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(supplierService.findSupplierById(id));
        }catch(Exception e){
            logger.error("No drug with id "+id+" in the system");
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
            logger.error("Supplier not created.");
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
            logger.error("Supplier not updated.");
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
            logger.error("Supplier not deleted.");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Supplier with id "+id+" not found in the System");
        }
    }
}

