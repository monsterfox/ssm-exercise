package com.foxbill;

import com.foxbill.config.SpringConfig;
import com.foxbill.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        /*
            测试Spring和SpringMVC分别扫描组件
                1.需要注释掉SpringMvcConfig中的@Configuration，否则仍然可以扫描到
         */
        AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext();
        cxt.register(SpringConfig.class);
        cxt.refresh();
        UserController userController = cxt.getBean(UserController.class);
        System.out.println(userController);

    }
}
