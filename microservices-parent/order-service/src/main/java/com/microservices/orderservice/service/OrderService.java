package com.microservices.orderservice.service;

import com.microservices.orderservice.dto.OrderLineIremsDto;
import com.microservices.orderservice.dto.OrderRequest;
import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.model.OrderLineItems;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRequest.getOrderLineIremsDtoList()
                .stream()
                .map(orderLineIremsDto -> mapToDto(orderLineIremsDto))


    }

    private OrderLineItems mapToDto(OrderLineIremsDto orderLineIremsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
    }

}
