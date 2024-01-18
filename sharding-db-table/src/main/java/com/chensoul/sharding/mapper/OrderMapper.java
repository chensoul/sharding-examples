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
	//新增
	@Insert("insert into t_order(price,user_id,status) values(#{price},#{userId},#{status})")
	public int insertOrder(Order order);

	//根据id查询多个订单
	@Select({"<script>" +
			 "select " +
			 "*" +
			 "from t_order t " +
			 "where t.order_id in " +
			 "<foreach collection='orderIds' item='id' open='(' separator=',' close=')'>" +
			 "#{id}" +
			 "</foreach>" +
			 "</script>"})
	public List<Map> listByOrderIds(@Param("orderIds") List<Long> orderIds);

	//根据订单id和userId查询多个订单
	@Select({"<script>" +
			 "select " +
			 "* " +
			 "from t_order t " +
			 "where t.order_id in " +
			 "<foreach collection='orderIds' item='id' open='(' separator=',' close=')'>" +
			 "#{id} " +
			 "</foreach>" +
			 "AND t.user_id=#{userId}" +
			 "</script>"})
	public List<Map> listByUserIdAndOrderIds(@Param("userId") Long userId, @Param("orderIds") List<Long> orderIds);
}
