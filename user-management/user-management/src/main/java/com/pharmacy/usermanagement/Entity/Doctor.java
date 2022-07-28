package com.pharmacy.usermanagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    private String doctor_Id;
    private String doctor_name;
    @Column(unique = true)
    private String doctor_email;
    private String doctor_password;
    private int doctor_contact;


    public Doctor() {
    }

    public Doctor(String doctor_Id, String doctor_name, String doctor_email, String doctor_password, int doctor_contact) {
        this.doctor_Id = doctor_Id;
        this.doctor_name = doctor_name;
        this.doctor_email = doctor_email;
        this.doctor_password = doctor_password;
        this.doctor_contact = doctor_contact;
    }

    public String getDoctor_Id() {
        return doctor_Id;
    }

    public void setDoctor_Id(String doctor_Id) {
        this.doctor_Id = doctor_Id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_email() {
        return doctor_email;
    }

    public void setDoctor_email(String doctor_email) {
        this.doctor_email = doctor_email;
    }

    public String getDoctor_password() {
        return doctor_password;
    }

    public void setDoctor_password(String doctor_password) {
        this.doctor_password = doctor_password;
    }

    public int getDoctor_contact() {
        return doctor_contact;
    }

    public void setDoctor_contact(int doctor_contact) {
        this.doctor_contact = doctor_contact;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_Id='" + doctor_Id + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", doctor_email='" + doctor_email + '\'' +
                ", doctor_password='" + doctor_password + '\'' +
                ", doctor_contact=" + doctor_contact +
                '}';
    }
}
