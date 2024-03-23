package com.lee.cloud.service;

import com.lee.cloud.entities.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);

}

