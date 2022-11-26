package com.dev.app.bookstorerestapi.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order extends BaseEntity {

    private String orderNumber;
    private LocalDate dateOrdered;
    private int booksQuantity;
    private float totalPrice;
    private OrderStatus orderStatus;

    private Customer customer;

    private List<Book> books = new ArrayList<>();

    public Order() {
    }

    public Order(Long id, String orderNumber,
                 LocalDate dateOrdered,
                 int booksQuantity, float totalPrice,
                 OrderStatus orderStatus,
                 Customer customer, List<Book> books) {
        super(id);
        this.orderNumber = orderNumber;
        this.dateOrdered = dateOrdered;
        this.booksQuantity = booksQuantity;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.customer = customer;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public int getBooksQuantity() {
        return booksQuantity;
    }

    public void setBooksQuantity(int booksQuantity) {
        this.booksQuantity = booksQuantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", dateOrdered=" + dateOrdered +
                ", booksQuantity=" + booksQuantity +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                ", customer=" + customer +
                ", books=" + books +
                '}';
    }
}
