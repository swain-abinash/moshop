package com.moshop.backend.controller;

import com.moshop.backend.model.dto.OrderRequestDTO;
import com.moshop.backend.model.entity.Order;
import com.moshop.backend.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/{customerId}")
    public ResponseEntity<Void> createOrder(@PathVariable String customerId, @RequestBody OrderRequestDTO orderRequestDTO){
        orderService.createOrder(customerId, orderRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        var orders = orderService.getOrders();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable String customerId){
        var orders=orderService.getOrders(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/{orderId}/{customerId}")
    public ResponseEntity<Order> getOrder(@PathVariable String orderId, @PathVariable String customerId){
        var order=orderService.getOrder(orderId, customerId);
        if (order != null){
            return ResponseEntity.ok(order);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable String orderId){
        Order order=orderService.getOrder(orderId);
        if (order != null){
            return ResponseEntity.ok(order);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/count")
    public  ResponseEntity<Long> countAllOrders(){
        long count=orderService.countAll();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/count/{customerId}")
    public ResponseEntity<Long> countOrdersByCustomerId(@PathVariable String customerId){
        long count=orderService.countAll(customerId);
        return ResponseEntity.ok(count);
    }
}
