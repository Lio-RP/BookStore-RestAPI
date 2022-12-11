package com.dev.app.bookstorerestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

    @OneToOne
    private User user;

    @OneToMany
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("customer")
    private List<Order> orders = new ArrayList<>();
}
