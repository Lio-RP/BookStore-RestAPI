package com.dev.app.bookstorerestapi.domain;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {

    private String phoneNumber;

    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(Long id, String firstName, String lastName, String email, String phoneNumber) {
        super(id, firstName, lastName, email);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", books=" + books +
                '}';
    }
}
