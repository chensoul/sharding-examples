package com.chensoul.sharding;

import com.chensoul.sharding.domain.Order;
import com.chensoul.sharding.mapper.OrderMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShardingTableApplicationTest {
	@Autowired
	private OrderMapper orderMapper;

	@Test
	public void testInsertOrder() {
		for (int i = 0; i < 10; i++) {
			Order order = new Order();
			order.setPrice(new BigDecimal((i + 1) * 5));
			order.setStatus("success" + "|" + i);
			order.setUserId(1L);
			orderMapper.insertOrder(order);
		}
	}

	@Test
	public void testSelect() {
		List<Long> orderIds = new ArrayList<>();
		orderIds.add(491708667008122880L);
		orderIds.add(491708666341228545L);
		orderMapper.listByOrderIds(orderIds);
	}

}
