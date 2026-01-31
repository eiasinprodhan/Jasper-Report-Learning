package com.springboot.practice.service;

import com.springboot.practice.dto.request.OrderRequest;
import com.springboot.practice.dto.response.OrderResponse;
import com.springboot.practice.entity.Order;
import com.springboot.practice.entity.User;
import com.springboot.practice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    public OrderResponse createOrder(OrderRequest request) {
        User user = userService.getUserById(request.getUserId());

        Order order = new Order(
                request.getProduct(),
                request.getPrice(),
                LocalDateTime.now(),
                user
        );

        orderRepository.save(order);

        return new OrderResponse(
                order.getId(),
                order.getProduct(),
                order.getPrice(),
                order.getOrderDate(),
                user.getId()
        );
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderResponse(
                        order.getId(),
                        order.getProduct(),
                        order.getPrice(),
                        order.getOrderDate(),
                        order.getUser().getId()
                )).collect(Collectors.toList());
    }

}
