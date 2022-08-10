package com.pharmacy.ordermanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class Drug {
    private String drugId;
    @ApiModelProperty(hidden = true)
    private String drugName;
    private int drugQuantity;
    @ApiModelProperty(hidden = true)
    private Date expiryDate;
    @ApiModelProperty(hidden = true)
    private double price;
    @ApiModelProperty(hidden = true)
    private String batchId;


    public Drug() {
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugId='" + drugId + '\'' +
                ", drugName='" + drugName + '\'' +
                ", drugQuantity=" + drugQuantity +
                ", expiryDate=" + expiryDate +
                ", price=" + price +
                ", batchId='" + batchId + '\'' +
                '}';
    }
}
