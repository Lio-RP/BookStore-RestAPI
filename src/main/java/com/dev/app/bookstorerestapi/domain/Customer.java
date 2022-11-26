package com.dev.app.bookstorerestapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends Person {


    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    private int zipcode;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<Order> orders = new ArrayList<>();
}
