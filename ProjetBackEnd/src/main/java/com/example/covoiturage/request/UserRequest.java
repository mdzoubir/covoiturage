package com.example.covoiturage.request;

public class UserRequest {
    private String fullName;
    private String username;
    private String telephone;
    private String email;
    private String password;

    public  UserRequest( String fullName,String username,String email,String password,String telephone)
    {
        this.fullName=fullName;
        this.username=username;
        this.email=email;
        this.password=password;
        this.telephone=telephone;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
