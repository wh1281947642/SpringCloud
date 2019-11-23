package cn.itcast.service.mapper;

import cn.itcast.service.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import tk.mybatis.mapper.common.Mapper;

/**
 * <p>
 * <code>UserMapper</code>
 * </p>
 * Description:
 *
 * @author huiwang45
 * @date 2019/10/19 14:21
 */
//@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
}
