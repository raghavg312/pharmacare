package com.pharmacy.usermanagement.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Doctor")
@ApiModel(description = "Details about Doctor")
public class Doctor {

    @Id
//    @ApiModelProperty(notes = "Unique Id of doctor")
    @ApiModelProperty(hidden = true)
    private String doctorId;

    @ApiModelProperty(notes = "Name of doctor")
    private String doctorName;

    @ApiModelProperty(notes = "Email address of doctor")
    private String doctorEmail;

    @ApiModelProperty(notes = "Password of doctor")
    private String doctorPassword;

    @ApiModelProperty(notes = "Contact number of doctor")
    private int doctorContact;

    public Doctor() {
    }

    public Doctor(String doctorId, String doctorName, String doctorEmail, String doctorPassword, int doctorContact) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorEmail = doctorEmail;
        this.doctorPassword = doctorPassword;
        this.doctorContact = doctorContact;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public int getDoctorContact() {
        return doctorContact;
    }

    public void setDoctorContact(int doctorContact) {
        this.doctorContact = doctorContact;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", doctorPassword='" + doctorPassword + '\'' +
                ", doctorContact=" + doctorContact +
                '}';
    }
}
