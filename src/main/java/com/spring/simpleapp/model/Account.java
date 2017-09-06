package com.spring.simpleapp.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "account")
@NamedQueries({
        @NamedQuery(name = "accountForUserName", query = "FROM Account WHERE username=:username AND password=:password"),
        @NamedQuery(name = "deleteUser", query = "DELETE FROM Account WHERE username=:username")
})
public class Account implements Serializable {

    @Id
    @GenericGenerator(name="kaugen", strategy = "increment")
    @GeneratedValue(generator = "kaugen")
    @Column(name = "intAccId")
    private int accountId;

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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

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
        return "Account{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }

}
