package com.pharmacy.drugmanagement.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Drug {
    @Id
    private String drugId;
    private String drugName;
    private int drugQuantity;
    private Date expiryDate;
    private double price;
    private String batchId;

    public Drug() {
    }

    public Drug(String drugId, String drugName, int drugQuantity, Date expiryDate, double price, String batchId) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugQuantity = drugQuantity;
        this.expiryDate = expiryDate;
        this.price = price;
        this.batchId = batchId;
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