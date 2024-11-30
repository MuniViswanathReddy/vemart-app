package com.veemart.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    @Column(name = "name")
    public String name;
    @Column(name = "password")
    public String password;
    @Column(name = "email")
    public String email;
    @Column(name = "mobile_no")
    public String mobileNo;
    @Column(name = "gender")
    public String gender;
    @Column(name = "dob")
    public String dob;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    public List<Address> addresses;
}
