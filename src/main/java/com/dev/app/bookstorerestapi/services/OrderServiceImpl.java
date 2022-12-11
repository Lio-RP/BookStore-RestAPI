package com.dev.app.bookstorerestapi.services;

import com.dev.app.bookstorerestapi.domain.*;
import com.dev.app.bookstorerestapi.repositories.CartRepository;
import com.dev.app.bookstorerestapi.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public Order create(User user) {
        Order order = new Order();

        List<Cart> carts = cartRepository.findCartsByUser(user);
        List<Book> books = new ArrayList<>();
        float totalPrice = 0;
        int totalQuantity = 0;
        for(Cart cart : carts){
            books.add(cart.getBook());
            totalPrice += cart.getSubtotalPrice();
            totalQuantity += cart.getQuantity();
        }

        Random rnd = new Random();
        String orderNumber = "";
        for(int i = 0; i < 10; i++){
            orderNumber += rnd.nextInt(10 - 1) + 1;
        }

        order.setOrderNumber(Integer.parseInt(orderNumber));
        order.setOrderStatus(OrderStatus.CREATED);
        order.setBooks(books);
        order.setDateOrdered(LocalDate.now());
        order.setCustomer(user.getCustomer());
        order.setBooksQuantity(totalQuantity);
        order.setTotalPrice(totalPrice);

        Order savedOrder = orderRepository.save(order);

        return savedOrder;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
