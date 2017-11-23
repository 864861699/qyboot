package com.ax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目启动类
 */
@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
public class app {

    public static void main(String[] args) {
        SpringApplication.run(app.class,args);
        System.out.println("开启成功！");
    }
}
