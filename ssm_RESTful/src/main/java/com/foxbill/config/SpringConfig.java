package com.foxbill.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MyBatisConfig.class})
@ComponentScan("com.foxbill.service")
//@ComponentScan(value = "com.foxbill",excludeFilters = @ComponentScan.Filter(
//    type = FilterType.ANNOTATION,
//        classes = Controller.class
//))
//开启事务管理
@EnableTransactionManagement
public class SpringConfig {
}
