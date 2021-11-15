package com.example.hospital.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Admin extends User{
    public Admin() {
    }

    public Admin(String first_name, String last_name, String email, String password, String mobile_no, String gender, long age, Collection<Role> roles) {
        super(first_name, last_name, email, password, mobile_no, gender, age, roles);
    }

//    public Admin(String first_name, String last_name, String email, String password, String mobile_no, String gender, long age) {
//        super(first_name, last_name, email, password, mobile_no, gender, age);
//    }
}
