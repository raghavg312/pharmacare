package com.pharmacy.usermanagement.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
    @Id
    private String admin_Id;
    private String admin_name;
    private String admin_email;
    private String admin_password;
    private int admin_contact;

    public Admin() {
    }

    public Admin(String admin_Id, String admin_name, String admin_email, String admin_password, int admin_contact) {
        this.admin_Id = admin_Id;
        this.admin_name = admin_name;
        this.admin_email = admin_email;
        this.admin_password = admin_password;
        this.admin_contact = admin_contact;
    }

    public String getAdmin_Id() {
        return admin_Id;
    }

    public void setAdmin_Id(String admin_Id) {
        this.admin_Id = admin_Id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public int getAdmin_contact() {
        return admin_contact;
    }

    public void setAdmin_contact(int admin_contact) {
        this.admin_contact = admin_contact;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_Id='" + admin_Id + '\'' +
                ", admin_name='" + admin_name + '\'' +
                ", admin_email='" + admin_email + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", admin_contact=" + admin_contact +
                '}';
    }
}
