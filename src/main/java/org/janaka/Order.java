package org.janaka;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "Order2")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private String orderId;

    private String customerId;

    private List<String> orderItems;

    private String orderDetails;

    public Order(String orderId, String customerId, List<String> orderItems) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderItems = orderItems;
    }
    public void updateDetails(String newDetails) {
        this.orderDetails = newDetails;
    }
}
