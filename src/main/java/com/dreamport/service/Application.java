package com.dreamport.service;

import com.dreamport.service.config.SwaggerConfigurer;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by ren.xiaobo on 2017/2/8.
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.dreamport"})
@ServletComponentScan(basePackages = {"com.dreamport.service.config"})
@EnableTransactionManagement
public class Application implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        SwaggerConfigurer.initSwagger("bs-dreamport-user", "bs-dreamport-user");
    }

    /**
     * (non-Javadoc)
     *
     * @see CommandLineRunner#run(String[])
     * <p>
     * 在SpringBoot应用启动之前执行一些代码。比如：<br/>
     * 1. 打印信息<br/>
     * 2. 初始化参数<br/>
     * ...
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("app start......");
    }
}