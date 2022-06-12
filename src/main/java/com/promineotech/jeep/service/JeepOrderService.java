package com.promineotech.jeep.service;

import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;

public interface JeepOrderService {
    Order createOrder(OrderRequest orderRequest);
}
