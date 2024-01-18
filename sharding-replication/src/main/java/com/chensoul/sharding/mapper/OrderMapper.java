package com.chensoul.sharding.mapper;

import com.chensoul.sharding.domain.Order;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 订单mapper接口
 */
@Mapper
public interface OrderMapper {
	@Insert("insert into t_order(price,user_id,status) values(#{price},#{userId},#{status})")
	int insertOrder(Order order);

	@Select({"<script>" +
			 "select " +
			 "*" +
			 "from t_order t " +
			 "where t.order_id in " +
			 "<foreach collection='orderIds' item='id' open='(' separator=',' close=')'>" +
			 "#{id}" +
			 "</foreach>" +
			 "</script>"})
	List<Map> listByOrderIds(@Param("orderIds") List<Long> orderIds);
}
