package com.example.duynguyen.contact;


import java.io.Serializable;


public class doituong implements Serializable {
    private String filsname, mobile, email;
    int id;
    public doituong(){

    }
    public doituong(int id, String filsname, String mobile, String email){
        this.id = id;
        this.filsname = filsname;
        this.mobile = mobile;
        this.email = email;
    }
    public doituong(String filsname, String mobile, String email) {
        this.filsname = filsname;
        this.mobile = mobile;
        this.email = email;
    }

    public String getFilsname() {
        return filsname;
    }

    public void setFilsname(String filsname) {
        this.filsname = filsname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
