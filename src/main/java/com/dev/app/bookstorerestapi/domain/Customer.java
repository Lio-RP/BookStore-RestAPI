package com.dev.app.bookstorerestapi.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {


    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    private int zipcode;

    private List<Order> orders = new ArrayList<>();

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName,
                    String phoneNumber, String email,
                    String address, String city,
                    String country, int zipcode, List<Order> orders) {
       super(id, firstName, lastName, email);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipcode=" + zipcode +
                ", orders=" + orders +
                '}';
    }
}
