package cn.com.demo.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//启动spring容器
@ComponentScan(basePackages = {"cn.com.demo.springboot.demo.service.Impl",
                                "cn.com.demo.springboot.demo.controller",
                                "cn.com.demo.springboot.demo.config"})
// 扫描MyBatis的接口包，实现动态绑定
@MapperScan(basePackages = "cn.com.demo.springboot.demo.mapper")
//开启注解
@EnableTransactionManagement
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
