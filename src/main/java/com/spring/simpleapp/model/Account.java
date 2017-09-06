package com.spring.simpleapp.model;


import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "account")
public class Account {

    @Id
    @Generated(value = "assigned")
    @Column(name = "intAccId")
    private Integer accountId;

    @Column(name = "strName")
    private String name;

    @Column(name = "strUserName")
    private String username;

    @Column(name = "strPassword")
    private String password;

    @Column(name = "strEmailId")
    private String emailId;

    @Column(name = "strMobileNo")
    private String mobileNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "Account [name=" + name + ", username=" + username + ", password=" + password + ", emailId=" + emailId
                + ", mobileNo=" + mobileNo + "]";
    }

}
