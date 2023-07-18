package com.example.formationstage.Models;

public class UserProfile {

    private String Username,Email,PhoneNumber;

    public UserProfile() {
    }

    public UserProfile(String username, String email, String phoneNumber) {
        this.Username = username;
        this.Email = email;
        this.PhoneNumber = phoneNumber;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }
}
