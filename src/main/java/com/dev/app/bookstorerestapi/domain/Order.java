package com.dev.app.bookstorerestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private String orderNumber;
    private LocalDate dateOrdered;
    private int booksQuantity;
    private float totalPrice;
    private OrderStatus orderStatus;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "order_book", joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books = new ArrayList<>();

}
