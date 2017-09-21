package com.example.nishan.bloodhub.Model;

/**
 * Created by nishan on 9/18/17.
 */

public class Registration {


    private String name;
    private String address;
    private String email;
    private String Mbn;
    private String password;
    private String reenter_password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email= email;
    }

    public String getMbn() {
        return Mbn;
    }

    public void setMbn(String Mbn) {
        this.Mbn = Mbn;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReenter_password() {
        return reenter_password;
    }

    public void setReenter_password(String reenter_password) {
        this.name = reenter_password;
    }




}
