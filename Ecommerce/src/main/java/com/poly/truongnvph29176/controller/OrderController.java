package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.entity.Order;
import com.poly.truongnvph29176.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final HttpServletRequest request;

    @GetMapping("/list")
    public String getAllOrder(Model model) {
        String username = request.getRemoteUser();
        List<Order> list = orderService.findByUserName(username);
        model.addAttribute("orders", list);
        return "order/list";
    }

    @GetMapping("/checkout")
    public String checkOut() {

        return "order/checkout";
    }

    @GetMapping("/detail/{id}")
    public String orderDetail(Model model, @PathVariable("id") Long id) {
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "order/detail";
    }
}
