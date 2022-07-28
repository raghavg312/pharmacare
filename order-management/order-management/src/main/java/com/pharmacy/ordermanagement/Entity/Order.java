package com.pharmacy.ordermanagement.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "orders")
public class Order {
    @Id
    public String Order_ID;
    public String Drug_ID;
    public String Doc_ID;
    public int Quantity;
    public int Total_Price;
    public Boolean Picked_Up;

    public Order(String order_ID, String drug_ID, String doc_ID, int quantity, int total_Price, Boolean picked_Up) {
        Order_ID = order_ID;
        Drug_ID = drug_ID;
        Doc_ID = doc_ID;
        Quantity = quantity;
        Total_Price = total_Price;
        Picked_Up = picked_Up;
    }
    public Order(){

    }

    public String getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(String order_ID) {
        Order_ID = order_ID;
    }

    public String getDrug_ID() {
        return Drug_ID;
    }

    public void setDrug_ID(String drug_ID) {
        Drug_ID = drug_ID;
    }

    public String getDoc_ID() {
        return Doc_ID;
    }

    public void setDoc_ID(String doc_ID) {
        Doc_ID = doc_ID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(int total_Price) {
        Total_Price = total_Price;
    }

    public Boolean getPicked_Up() {
        return Picked_Up;
    }

    public void setPicked_Up(Boolean picked_Up) {
        Picked_Up = picked_Up;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Order_ID=" + Order_ID +
                ", Drug_ID='" + Drug_ID + '\'' +
                ", Doc_ID='" + Doc_ID + '\'' +
                ", Quantity=" + Quantity +
                ", Total_Price=" + Total_Price +
                ", Picked_Up=" + Picked_Up +
                '}';
    }
}