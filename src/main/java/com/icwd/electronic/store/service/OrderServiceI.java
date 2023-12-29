package com.icwd.electronic.store.service;

import com.icwd.electronic.store.dto.OrderDto;
import com.icwd.electronic.store.dto.PageableResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderServiceI {

    //create order
    OrderDto createOrder(OrderDto orderDto, String id, String cartId);

    //remove order
    void removeOrder(String orderId);

    //get orders of user
    List<OrderDto> getOrdersOfUser(String id);

    //get orders
    PageableResponse<OrderDto> getOrders(int pageNumber, int pageSize, String sortBy, String sortDir);
}
