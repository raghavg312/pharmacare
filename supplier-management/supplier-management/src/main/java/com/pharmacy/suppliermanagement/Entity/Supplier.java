package com.pharmacy.suppliermanagement.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "Supplier")
@ApiModel(description = "Details of Suppliers")

public class Supplier {

    @Id
//  @ApiModelProperty(notes = "Unique Id of suppliers")
    @ApiModelProperty(hidden = true)
    private String SupplierId;

    @ApiModelProperty(notes = "Name of Supplier")
    private String SupplierName;

    @ApiModelProperty(notes = "Email of supplier")
    private String SupplierEmail;

    @ApiModelProperty(notes = "Contact number of supplier")
    private int SupplierContact;

    public Supplier() {
    }

    public Supplier(String supplierId, String supplierName, String supplierEmail, int supplierContact) {
        SupplierId = supplierId;
        SupplierName = supplierName;
        SupplierEmail = supplierEmail;
        SupplierContact = supplierContact;
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String supplierId) {
        SupplierId = supplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getSupplierEmail() {
        return SupplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        SupplierEmail = supplierEmail;
    }

    public int getSupplierContact() {
        return SupplierContact;
    }

    public void setSupplierContact(int supplierContact) {
        SupplierContact = supplierContact;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "SupplierId='" + SupplierId + '\'' +
                ", SupplierName='" + SupplierName + '\'' +
                ", SupplierEmail='" + SupplierEmail + '\'' +
                ", SupplierContact=" + SupplierContact +
                '}';
    }
}
