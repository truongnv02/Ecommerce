package com.poly.truongnvph29176.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.truongnvph29176.entity.Order;
import com.poly.truongnvph29176.entity.OrderDetail;
import com.poly.truongnvph29176.repository.OrderDetailRepository;
import com.poly.truongnvph29176.repository.OrderRepository;
import com.poly.truongnvph29176.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    @Override
    public Order createOrder(JsonNode orderNode) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderNode, Order.class);
        orderRepository.save(order);
        TypeReference<List<OrderDetail>> type = new TypeReference<>() {};
        List<OrderDetail> orderDetails = mapper.convertValue(orderNode.get("orderDetails"), type)
                .stream()
                .peek(d -> d.setOrder(order)).collect(Collectors.toList());
        orderDetailRepository.saveAll(orderDetails);
        return order;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> findByUserName(String username) {
        return orderRepository.findByUsername(username);
    }
}
