package org.janaka;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto {

    private String orderId;

    private String customerId;

    private List<String> orderItems;
}