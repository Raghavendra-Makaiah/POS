package com.ms.orderservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.orderservice.entity.Order;
import com.ms.orderservice.model.User;
import com.ms.orderservice.repository.OrderRepository;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public User getUserDetails(Long userId) {
        logger.debug("Inside getUserDetails of OrderService......" + userId);
        return restTemplate.getForObject("http://user-service/users/" + userId, User.class);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
