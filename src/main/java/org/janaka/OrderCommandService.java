package org.janaka;

import org.springframework.stereotype.Service;

@Service
public class OrderCommandService {

    private final OrderRepository orderRepository;

    public OrderCommandService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(CreateOrderCommand command) {
        // Perform validations, business logic, etc.
        // Create and persist the order
        Order order = new Order(command.getOrderId(), command.getCustomerId(), command.getItems());
        orderRepository.save(order);
    }

    public void updateOrder(UpdateOrderCommand command) {
        // Perform validations, business logic, etc.
        // Update the order
        Order order = orderRepository.findById(command.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException(command.getOrderId()));

        // Update order details based on command
        order.updateDetails(command.getNewDetails());

        orderRepository.save(order);
    }

    // Other command-related operations
}
