package cn.itcast.service.client;

import cn.itcast.service.pojo.User;
import org.springframework.stereotype.Component;

/**
 * <p>
 * <code>UserClientFallback</code>
 * </p>
 *
 * @author huiwang45@iflytek.com
 * @description
 * @date 2019/10/24 10:47
 */

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryUserById(String id) {
        User user = new User();
        user.setUsername("服务器正忙,请稍后再试");
        return user;
    }
}
