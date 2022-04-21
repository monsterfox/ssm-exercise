package com.foxbill.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration //设置当前类为配置类
@ComponentScan("com.foxbill")  //设定扫描路径，扫描dao和service组件等
@PropertySource("classpath:jdbc.properties")
//@ComponentScan({"com.foxbill.config","com.foxbill.dao","com.foxbill.service"}) // 如果要扫描配置类，同时需要在配置类上加@Configuration注解 【不推荐使用，因为隐藏性太强，不知道加载了哪些配置类】
@Import(JdbcConfig.class)//导入其他配置类【推荐】
public class SpringConfig {

}
