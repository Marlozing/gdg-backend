package com.example.demo.order;




import com.example.demo.order.dto.OrderCreateRequest;
import com.example.demo.order.dto.OrderUpdateRequest;

import java.util.List;

public class OrderService {

    private final OrderResposity orderResposity;

    //@Transactional
    public Long createOrder(OrderCreateRequest request) {
        Order existingOrder = orderResposity.findByOrderId(request.getOrderId()1);
        if (existingOrder != null) {
            throw new RuntimeException("이미 존재하는 주문입니다: " + request.getOrderId());
        }

        Order order = new Order(
                request.getOrderId()
        );

        orderRepository.save(order);

        return order.getId();
    }

    //@Transactional(readOnly=True)
    public List<Order> getAllOrders() {
        return orderResposity.findAll();
    }

    //@Transactional(readOnly=True)
    public Order getOrderById(Long id) {
        Order order = orderResposity.findById(id);

        if (order == null){
            throw new RuntimeException("주문을 찾을 수 없습니다");
        }

        return order;
    }

    //@Transactional
    public void updateOrder(Long id, OrderUpdateRequest request){
        Order order = orderResposity.findById(id);

        if (order == null){
            throw new RuntimeException("주문을 찾을 수 없습니다");
        }

        order.updateInfo();
    }

    //@Transactional
    public void deleteOrder(Long id){
        Order order = orderRepository.findById(id);

        if (order == null){
            throw new RuntimeException("주문을 찾을 수 없습니다");
        }

        orderResposity.deleteById(id);
    }
}
