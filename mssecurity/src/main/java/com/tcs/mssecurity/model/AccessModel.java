package com.tcs.mssecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "access")
public class AccessModel {
	
    @Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userId;
    
    @Column(name = "fullname")
    private String fullName;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    public Integer getUserId() {
        return userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
