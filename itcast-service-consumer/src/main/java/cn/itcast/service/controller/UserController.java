package cn.itcast.service.controller;

import cn.itcast.service.client.UserClient;
import cn.itcast.service.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <p>
 * <code>UserController</code>
 * </p>
 *
 * @author huiwang45@iflytek.com
 * @description
 * @date 2019/10/19 16:15
 */

@Controller
@RequestMapping("consumer/user")
@DefaultProperties(defaultFallback = "fallbackMethod") //定义全局的熔断方法
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    //@Autowired
    //private DiscoveryClient discoveryClient; //包含了拉取的所有的信息

    @GetMapping
    @ResponseBody
    @HystrixCommand//声明熔断的方法
    public String queryUserById(@RequestParam("id") String id) {
       /* if("1".equals(id)){
            throw new RuntimeException();
        }*/
        //List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        //ServiceInstance instance = instances.get(0);
        //return this.restTemplate.getForObject("http://service-provider/user/" + id, String.class);
        return  this.userClient.queryUserById(id ).toString();
    }

    public String fallbackMethod() {
       return  "服务器正忙，请稍后再试!";
    }
}
