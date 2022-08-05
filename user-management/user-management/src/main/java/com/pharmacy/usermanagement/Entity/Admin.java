package com.pharmacy.usermanagement.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

@Entity
@Table(name = "Admin")
@ApiModel(description = "Details about the admin")
public class Admin {

    @Id
    //@ApiModelProperty(notes = "The unique id of admin")
    @ApiModelProperty(hidden = true)
    private String adminId;

    @ApiModelProperty(notes = "Name of admin")
    private String adminName;

    @ApiModelProperty(notes = "Email address of admin")
    private String adminEmail;

    @ApiModelProperty(notes = "Password of admin")
    private String adminPassword;

    @ApiModelProperty(notes = "Contact number of admin")
    private int adminContact;

    public Admin() {
    }

    public Admin(String adminId, String adminName, String adminEmail, String adminPassword, int adminContact) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminContact = adminContact;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public int getAdminContact() {
        return adminContact;
    }

    public void setAdminContact(int adminContact) {
        this.adminContact = adminContact;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminContact=" + adminContact +
                '}';
    }
}
