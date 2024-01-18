package com.chensoul.sharding.domain;

import java.math.BigDecimal;
import lombok.Data;

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
