package org.janaka;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderQueryService {

    private final OrderRepository orderRepository;

    public OrderQueryService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto getOrderById(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));
        return new OrderDto(order.getOrderId(), order.getCustomerId(), order.getOrderItems());
    }

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> new OrderDto(order.getOrderId(), order.getCustomerId(), order.getOrderItems()))
                .collect(Collectors.toList());
    }

    // Other query-related operations
}
