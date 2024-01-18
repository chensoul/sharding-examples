package com.chensoul.sharding.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * user表的mapper接口
 */
@Mapper
public interface UserMapper {
	//插入用户
	@Insert("insert into t_user(fullname,user_type)values(#{fullname},#{userType})")
	public int insertUser(@Param("fullname") String fullname, @Param("userType") String userType);

	@Select("<script>" +
			"select" +
			" * " +
			" from t_user t " +
			" where t.user_id in " +
			" <foreach collection='userIds' open='(' separator=',' close=')' item='id'>" +
			" #{id} " +
			" </foreach>" +
			"</script>")
	public List<Map> listByOrderIds(@Param("userIds") List<Long> userIds);
}
