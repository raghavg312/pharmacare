package com.pharmacy.suppliermanagement.Entity;

import javax.persistence.*;

@Entity
public class Supplier {
    @Id
    private String Supplier_Id;
    private String Supplier_name;
    private String Supplier_email;
    private int Supplier_contact;

    public Supplier() {
    }

    public Supplier(String supplier_Id, String supplier_name, String supplier_email, int supplier_contact) {
        Supplier_Id = supplier_Id;
        Supplier_name = supplier_name;
        Supplier_email = supplier_email;
        Supplier_contact = supplier_contact;
    }

    public String getSupplier_Id() {
        return Supplier_Id;
    }

    public void setSupplier_Id(String supplier_Id) {
        Supplier_Id = supplier_Id;
    }

    public String getSupplier_name() {
        return Supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        Supplier_name = supplier_name;
    }

    public String getSupplier_email() {
        return Supplier_email;
    }

    public void setSupplier_email(String supplier_email) {
        Supplier_email = supplier_email;
    }

    public int getSupplier_contact() {
        return Supplier_contact;
    }

    public void setSupplier_contact(int supplier_contact) {
        Supplier_contact = supplier_contact;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "Supplier_Id='" + Supplier_Id + '\'' +
                ", Supplier_name='" + Supplier_name + '\'' +
                ", Supplier_email='" + Supplier_email + '\'' +
                ", Supplier_contact=" + Supplier_contact +
                '}';
    }
}
