package com.programmingtechie.orderservice.service;

import com.programmingtechie.orderservice.dto.OrderLineItemsDto;
import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.model.OrderLineItems;
import com.programmingtechie.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems =  new ArrayList<>();
        if (orderRequest.getOrderLineItemsList() != null) {
            orderLineItems = orderRequest.getOrderLineItemsList()
                    .stream()
                    .map(this::mapToDTO)
                    .toList();
        }


        /*List<OrderLineItems> orderLineItems =  orderRequest.getOrderLineItemsList()
                .stream()
                .map(this::mapToDTO)
                .toList();*/

        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);

    }

    private OrderLineItems mapToDTO(OrderLineItemsDto orderLineItemsDto) {

        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;

    }

}
