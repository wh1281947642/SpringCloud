package cn.itcast.service.client;

import cn.itcast.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * <code>UserClient</code>
 * </p>
 * Description:
 *
 * @author huiwang45
 * @date 2019/10/24 10:01
 */

@FeignClient(value = "service-provider",fallback = UserClientFallback.class) //声明一个接口是feign接口,指定服务id
public interface UserClient {

    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable("id") String id);
}
