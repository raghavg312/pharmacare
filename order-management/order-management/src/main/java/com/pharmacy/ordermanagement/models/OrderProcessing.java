package com.pharmacy.ordermanagement.models;

import java.util.List;

public class OrderProcessing {

    private String orderId;
    private String doctorId;
    private List<OrderedDrug> orderedDrugList;

    public OrderProcessing() {
    }

    public OrderProcessing(String orderId, String doctorId, List<OrderedDrug> orderedDrugList) {
        this.orderId = orderId;
        this.doctorId = doctorId;
        this.orderedDrugList = orderedDrugList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public List<OrderedDrug> getOrderedDrugList() {
        return orderedDrugList;
    }

    public void setOrderedDrugList(List<OrderedDrug> orderedDrugList) {
        this.orderedDrugList = orderedDrugList;
    }
}
