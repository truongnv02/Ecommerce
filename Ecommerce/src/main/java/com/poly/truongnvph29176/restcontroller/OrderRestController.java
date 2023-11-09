package com.poly.truongnvph29176.restcontroller;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.truongnvph29176.entity.Order;
import com.poly.truongnvph29176.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class OrderRestController {
    private final OrderService orderService;

    @PostMapping("/orders")
    public Order create(@RequestBody JsonNode orderNode) {
        return orderService.createOrder(orderNode);
    }
}
