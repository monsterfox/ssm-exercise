package com.foxbill.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * springMvc取消 web.xml文件
 *
 */
@Configuration
@ComponentScan("com.foxbill.controller")
public class SpringMvcConfig {
}