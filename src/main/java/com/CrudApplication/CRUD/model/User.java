package com.CrudApplication.CRUD.model;

import lombok.Data;

import javax.persistence.*;
import java.lang.annotation.Documented;

@Entity
@Data
@Table(name = "users")

public class User {

    @Id
    private Integer phone;

    @Column
    private String name;

    @Column
    private String lname;

    @Column
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "phone=" + phone +
                ", name='" + name + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User()
    {
        super();
    }
    public User(int phone, String name, String lname, String email) {
        this.phone = phone;
        this.name = name;
        this.lname = lname;
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
