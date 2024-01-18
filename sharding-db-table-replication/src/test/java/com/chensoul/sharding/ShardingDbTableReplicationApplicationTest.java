package com.chensoul.sharding;

import com.chensoul.sharding.domain.Order;
import com.chensoul.sharding.mapper.OrderMapper;
import com.chensoul.sharding.mapper.UserMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShardingDbTableReplicationApplicationTest {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private UserMapper userMapper;

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

	@Test
	public void testInsertTable() {
		for (int i = 0; i < 10; i++) {
			Order order = new Order();
			order.setPrice(new BigDecimal((i + 1) * 5));
			order.setStatus("WAIT_PAY" + "|" + i);
			order.setUserId(1L);
			orderMapper.insertOrder(order);
		}
		for (int i = 0; i < 10; i++) {
			Order order = new Order();
			order.setPrice(new BigDecimal((i + 1) * 10));
			order.setStatus("WAIT_PAY" + "|" + i);
			order.setUserId(2L);
			orderMapper.insertOrder(order);
		}
	}

	@Test
	public void testSelectByUserIdAndOrderId() {
		List<Long> orderIds = new ArrayList<>();
		orderIds.add(491708667008122880L);//在order_db_2库中t_order_1表
		orderIds.add(491708666341228545L);//在order_db_2库中t_order_2表
		Long userId = 1L;
		List<Map> maps = orderMapper.listByUserIdAndOrderIds(userId, orderIds);
		System.out.println(maps);
	}

	//测试新增
	@Test
	public void testInsertUser() {
		for (int i = 10; i < 14; i++) {
			userMapper.insertUser("张三" + i, "");
		}
	}

	//根据userId查询多个订单
	@Test
	public void testSelectUsers() {
		List<Long> userIds = new ArrayList<>();
		userIds.add(491956648743534593L);
		userIds.add(491956649020358656L);
		List<Map> maps = userMapper.listByOrderIds(userIds);
		System.out.println(maps);
	}
}
