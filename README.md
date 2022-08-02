# SSM知识练习
## 1. mybatis-quickstart
mybatis快速入门
实现功能：查询user表中所有数据
 1. 创建user表，添加数据 
 2. 创建模块，导入坐标 
 3. 编写 MyBatis 核心配置文件  -- > 替换连接信息 解决硬编码问题 
 4. 编写 SQL 映射文件 --> 统一管理sql语句，解决硬编码问题 
 5. 编码 
    1. 定义POJO类 
    2. 加载核心配置文件，获取 SqlSessionFactory 对象 
    3. 获取 SqlSession 对象，执行 SQL 语句 
    4. 释放资源 
 注意：在不使用代理开发之前，命名空间可以为test（即命名空间任意）
 
### Mybatis概要（官网）
1. 配置  configuration
2. xml映射器  mapper
3. 动态SQL
4. Java API
5. 日志

## mybatis-crud
基于Vue和ElementUI实现增删改查功能

JSON的jar包：1.fastjson 2.jackson

## 2. spring-quickstart
spring快速入门
1. IoC/DI
   1. <bean>(自定义bean、非自定义bean)
   2. 加载properties
   3. 组件扫描
   4. 引入文件
2. Aop
3. 事务

## 3. spring_annotation
spring注解配置
相关注解：
    1. @Configuration 配置类
    2. @ComponentScan 组件扫描，注入Bean
    3. @PropertySource 加载属性文件
    4. @Import 导入其他配置类
    5. @Value 把属性文件中的值，注入到配置类属性上
    6. @Bean 把方法返回值注入到Spring容器

## 4. spring_mybatis_integration
spring基于xml方式整合MyBatis

注入：
1. DruidDataSource
2. SqlSessionFactoryBean
3. MapperScannerConfigurer

## 5. spring_mybatis_integration_annotation
spring基于注解方式整合MyBatis
1. SpringConfig
   1. 配置类 @Configuration
   2. 自定义bean的注入 -  @ComponentScan("com.foxbill")
   3. 非自定义bean(外部bean)的注入 - @Import({JdbcConfig.class,MyBatisConfig.class})
      1. 引入属性文件 @PropertySource("classpath:jdbc.properties")
2. MyBatisConfig
   1. 非自定义bean(外部bean)的注入 - @Bean
3. JdbcConfig
   1. 非自定义bean(外部bean)的注入 - @Bean 、 @Value

## 6. spring_junit_integration
spring整合Junit

1)@RunWith：用于指定junit运行环境，是junit提供给其他框架测试环境接口扩展，为了便于使用spring的依赖注入，spring提供了org.springframework.test.context.junit4.SpringJUnit4ClassRunner作为Junit测试环境。
2)@ContextConfiguration({"classes=Congfig.clsss",classpath:applicationContext.xml"}) 这里可以用classes来直接导入同包下写的配置类。或者导入配置文件。

## 7. aop_quickstart
AOP快速入门

@EnableAspectJAutoProxy //开启注解开发AOP功能

## 8. spring-transaction
基于注解的事务
## 9. spring-transaction-xml
基于xml的事务
## 10.aop_xml
基于xml配置AOP
## 11.springmvc_quickstart

## 12.springmvc_nowebxml
使用java替换web.xml
## 13.springmvc_request_param
springmvc中的请求参数


