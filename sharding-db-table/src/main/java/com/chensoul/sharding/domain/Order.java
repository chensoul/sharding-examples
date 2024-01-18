package com.chensoul.sharding.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单实体
 */
@Data
public class Order {

    private Long orderId;
    private BigDecimal price;
    private Long userId;
    private String status;

}
