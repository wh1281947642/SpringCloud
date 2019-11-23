package cn.itcast.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

/**
 * <p>
 * <code>RibbonLoadBalanceTest</code>
 * </p>
 *
 * @author huiwang45@iflytek.com
 * @description
 * @date 2019/10/22 21:06
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RibbonLoadBalanceTest {

    @Autowired
    private RibbonLoadBalancerClient client;

    @org.junit.Test
    public void test(){

        for (int i = 0; i < 50; i++) {
            ServiceInstance instance = this.client.choose("service-provider");
            System.out.println(instance.getHost()+":"+instance.getPort());


        }

    }
}
