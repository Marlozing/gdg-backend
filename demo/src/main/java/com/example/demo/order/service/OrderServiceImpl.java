package com.example.demo.order.service;




import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.order.dto.OrderCreateRequest;
import com.example.demo.order.dto.OrderUpdateRequest;
import com.example.demo.order.entity.Order;
import com.example.demo.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Long createOrder(OrderCreateRequest request) {

        Member member = memberRepository.findById(request.getMemberId());

        if (member == null) {
            throw new RuntimeException("존재하지 않는 회원입니다: " + request.getMemberId());
        }

        Order order = new Order(
                member,
                request.getOrderDate(),
                request.getTotalPrice(),
                request.getPointused(),
                request.getCashAmount(),
                request.getStatus()
        );

        orderRepository.save(order);

        return order.getId();
    }

    @Override
    @Transactional(readOnly=true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null){
            throw new RuntimeException("주문을 찾을 수 없습니다");
        }

        return order;
    }

    @Override
    @Transactional
    public void updateOrder(Long id, OrderUpdateRequest request){
        Order order = orderRepository.findById(id);

        if (order == null){
            throw new RuntimeException("주문을 찾을 수 없습니다");
        }

        Member member = memberRepository.findById(request.getMemberId());

        if (member == null){
            throw new RuntimeException("존재하지 않는 회원입니다: " + request.getMemberId());
        }

        order.updateInfo(
                member,
                request.getOrderDate(),
                request.getTotalPrice(),
                request.getPointused(),
                request.getCashAmount(),
                request.getStatus()
        );
    }

    @Override
    @Transactional
    public void deleteOrder(Long id){
        Order order = orderRepository.findById(id);

        if (order == null){
            throw new RuntimeException("주문을 찾을 수 없습니다");
        }

        orderRepository.deleteById(id);
    }
}
