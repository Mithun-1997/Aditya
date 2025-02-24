package com.devops.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Long mobileNumber;
    private String password;
    private String validatePassword;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Long getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(Long mobileNumber) { this.mobileNumber = mobileNumber; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getValidatePassword() { return validatePassword; }
    public void setValidatePassword(String validatePassword) { this.validatePassword = validatePassword; }
}
