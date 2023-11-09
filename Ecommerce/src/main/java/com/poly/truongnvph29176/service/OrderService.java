package com.poly.truongnvph29176.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.truongnvph29176.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(JsonNode orderNode);
    Order findById(Long id);
    List<Order> findByUserName(String username);
}
