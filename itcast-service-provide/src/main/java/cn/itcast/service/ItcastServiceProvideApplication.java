package cn.itcast.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("cn.itcast.service.mapper") //mapper接口的包扫描  使用这个注解就不需要在每个mapper接口中加@mapper注解
@SpringBootApplication
//@EnableEurekaClient //启用Eureka客服端
@EnableDiscoveryClient
public class ItcastServiceProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItcastServiceProvideApplication.class, args);
    }

}
