package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.Order;
import com.dev.app.bookstorerestapi.domain.User;

import java.util.List;

public interface OrderService {

    Order create(User user);

    List<Order> getAllOrders();
}
