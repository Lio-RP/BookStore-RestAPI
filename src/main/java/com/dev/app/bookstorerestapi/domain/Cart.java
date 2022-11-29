package com.dev.app.bookstorerestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart extends BaseEntity {

    private int quantity;
    private float subtotalPrice;

    @OneToOne
    private Book book;

    @ManyToOne
    private User user;
}
