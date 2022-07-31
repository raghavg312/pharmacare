package com.pharmacy.ordermanagement.models;

public class OrderedDrug {
    private String drugId;
    private int quantity;

    public OrderedDrug() {
    }

    public OrderedDrug(String drugId, int quantity) {
        this.drugId = drugId;
        this.quantity = quantity;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
