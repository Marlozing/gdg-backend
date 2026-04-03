package com.example.demo.order;

import com.example.demo.order.dto.OrderCreateRequest;
import com.example.demo.order.dto.OrderUpdateRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderCreateRequest request){
        Long orderId = orderService.createOrder(request);
        return ResponseEntity.created(URI.create("/orders"+orderId)).build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> products = orderService.getAllOrders();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<Void> updateOrder(
            @PathVariable Long orderId,
            @RequestBody OrderUpdateRequest request) {
        orderService.updateOrder(orderId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{orderid}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
