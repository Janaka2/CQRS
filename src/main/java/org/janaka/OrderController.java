package org.janaka;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderCommandService orderCommandService;
    private final OrderQueryService orderQueryService;

    public OrderController(OrderCommandService orderCommandService, OrderQueryService orderQueryService) {
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderCommand command) {
        orderCommandService.createOrder(command);
        return ResponseEntity.ok("Order created successfully.");
    }

    @PutMapping("/orders/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable String orderId, @RequestBody UpdateOrderCommand command) {
        command.setOrderId(orderId);
        orderCommandService.updateOrder(command);
        return ResponseEntity.ok("Order updated successfully.");
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable String orderId) {
        OrderDto orderDto = orderQueryService.getOrderById(orderId);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderDtos = orderQueryService.getAllOrders();
        return ResponseEntity.ok(orderDtos);
    }


}
