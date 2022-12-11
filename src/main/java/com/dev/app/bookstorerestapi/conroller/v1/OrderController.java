package com.dev.app.bookstorerestapi.conroller.v1;

import com.dev.app.bookstorerestapi.auth.UserPrincipal;
import com.dev.app.bookstorerestapi.domain.Customer;
import com.dev.app.bookstorerestapi.domain.Order;
import com.dev.app.bookstorerestapi.domain.User;
import com.dev.app.bookstorerestapi.services.CustomerService;
import com.dev.app.bookstorerestapi.services.OrderService;
import com.dev.app.bookstorerestapi.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Order Controller")
@RequestMapping("/api/v1")
@RestController
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final CustomerService customerService;

    public OrderController(OrderService orderService,
                           UserService userService,
                           CustomerService customerService) {
        this.orderService = orderService;
        this.userService = userService;
        this.customerService = customerService;
    }

    @Operation(summary = "Get All Orders")
    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @Operation(summary = "Save Order")
    @GetMapping("/orders/save")
    @ResponseStatus(HttpStatus.OK)
    public Order saveOrder(@RequestBody Customer customer,
                           @AuthenticationPrincipal UserPrincipal userPrincipal){
        User user = userService.getCurrentlyLoggedUser(userPrincipal);
        customerService.create(customer, user);
        Order savedOrder = orderService.create(user);
        return savedOrder;
    }
}
