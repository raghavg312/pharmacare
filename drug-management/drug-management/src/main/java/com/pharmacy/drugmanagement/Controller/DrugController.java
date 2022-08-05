package com.pharmacy.drugmanagement.Controller;

import com.pharmacy.drugmanagement.Entity.Drug;
import com.pharmacy.drugmanagement.Service.DrugService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DrugController {

    @Autowired
    private DrugService drugService;

     Logger logger = LoggerFactory.getLogger(DrugController.class);

    @GetMapping("/drug")
    public ResponseEntity getDrug(){
        List<Drug> a = drugService.getDrug();
        if(!(a.isEmpty())){
            logger.info("Getting all drugs from the system");
            return ResponseEntity.ok(a);}
        else
        {logger.error("No drug found in system");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no drug in the system");
        }
    }

    @GetMapping("/drug/{drugId}")
    public ResponseEntity getDrugById(@PathVariable("drugId") String id){
        Optional<Drug> a = drugService.findDrugById(id);
        if(!(a.isEmpty())){
            logger.trace("Getting drug with id "+id+" from the system");
            return ResponseEntity.ok(a);}
        else {
            logger.error("No drug with id "+id+" in the system");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("There is no drug in the system with id "+id);
        }
    }

    @PostMapping("/drug")
    public ResponseEntity createDrug(@RequestBody Drug drug) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(drugService.saveDrug(drug));
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Drug was not created.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Drug not created. Check the inputs.");
        }
    }

    @PutMapping("/drug/{drugId}")
    public ResponseEntity updateDrug(@RequestBody Drug drug,@PathVariable("drugId") String id){

        try {
            return ResponseEntity.ok(drugService.updateDrug(drug,id));
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("Drug was not updated");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Drug with id "+id+" not found in the System");
        }
    }

    @DeleteMapping("/drug/{drugId}")
    public  ResponseEntity deleteDrug(@PathVariable("drugId") String id){
        try {
            return ResponseEntity.ok(drugService.deleteDrug(id));
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("No drug was deleted");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Drug with id "+id+" not found in the System");
        }
    }
    @PutMapping("/drug/quantity/{drugId}")
    public ResponseEntity<Drug> updateDrugQuantity(@RequestBody Drug drug, @PathVariable("drugId") String id) {
        return ResponseEntity.ok(drugService.updateDrugQuantity(drug, id));
    }
}
