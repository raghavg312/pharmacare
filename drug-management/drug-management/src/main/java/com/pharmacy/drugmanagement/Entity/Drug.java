package com.pharmacy.drugmanagement.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Drug {
    @Id
    private String Drug_ID;
    private String Drug_Name;
    private int Drug_Quantity;
    private Date Expiry_date;
    private int Price;
    private int Batch_ID;

    public Drug(String drug_ID, String drug_Name, int drug_Quantity, Date expiry_date, int price, int batch_ID) {
        Drug_ID = drug_ID;
        Drug_Name = drug_Name;
        Drug_Quantity = drug_Quantity;
        Expiry_date = expiry_date;
        Price = price;
        Batch_ID = batch_ID;
    }

    public Drug() {
    }

    public String getDrug_ID() {
        return Drug_ID;
    }

    public void setDrug_ID(String drug_ID) {
        Drug_ID = drug_ID;
    }

    public String getDrug_Name() {
        return Drug_Name;
    }

    public void setDrug_Name(String drug_Name) {
        Drug_Name = drug_Name;
    }

    public int getDrug_Quantity() {
        return Drug_Quantity;
    }

    public void setDrug_Quantity(int drug_Quantity) {
        Drug_Quantity = drug_Quantity;
    }

    public Date getExpiry_date() {
        return Expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        Expiry_date = expiry_date;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getBatch_ID() {
        return Batch_ID;
    }

    public void setBatch_ID(int batch_ID) {
        Batch_ID = batch_ID;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "Drug_ID='" + Drug_ID + '\'' +
                ", Drug_Name='" + Drug_Name + '\'' +
                ", Drug_Quantity=" + Drug_Quantity +
                ", Expiry_date=" + Expiry_date +
                ", Price=" + Price +
                ", Batch_ID=" + Batch_ID +
                '}';
    }
}
