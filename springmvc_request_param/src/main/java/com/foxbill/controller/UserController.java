package com.foxbill.controller;

import com.foxbill.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/save")
    @ResponseBody
    public String save(String name) {
        System.out.println("user...save..");
        System.out.println(name);
        return "{'msg':'hello springmvc'}";
    }

    @RequestMapping("/commonParamDifferentName")
    @ResponseBody
    public String commonParamDifferentName(@RequestParam("name") String username, int age) {
        System.out.println("user...common..");
        System.out.println(username);
        System.out.println(age);
        return "{'module':'common param different name'}";
    }

    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user) {
        System.out.println("user...common..");
        System.out.println("pojo参数传递 user ==>" + user);
        return "{'module':'pojo Param'}";
    }

    //嵌套POJO参数：嵌套属性按照层次结构设定名称即可完成参数传递
    @RequestMapping("/pojoContainPojoParam")
    @ResponseBody
    public String pojoContainPojoParam(User user) {
        System.out.println("pojo嵌套pojo参数传递 user ==> " + user);
        return "{'module':'pojo contain pojo param'}";
    }

    //数组参数：同名请求参数可以直接映射到对应名称的形参数组对象中
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes) {
        System.out.println("数组参数传递 likes ==> " + Arrays.toString(likes));
        return "{'module':'array param'}";
    }

    //集合参数：同名请求参数可以使用@RequestParam注解映射到对应名称的集合对象中作为数据
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes) {
        System.out.println("集合参数传递 likes ==> " + likes);
        return "{'module':'list param'}";
    }

    //集合参数：json格式
    //1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    //2.使用@RequestBody注解将外部传递的json数组数据映射到形参的集合对象中作为数据
    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes) {
        System.out.println("list common(json)参数传递 list ==> " + likes);
        return "{'module':'list common for json param'}";
    }

    //POJO参数：json格式
    //1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    //2.使用@RequestBody注解将外部传递的json数据映射到形参的实体类对象中，要求属性名称一一对应
    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody User user){
        System.out.println("pojo(json)参数传递 user ==> "+user);
        return "{'module':'pojo for json param'}";
    }

    //集合参数：json格式
    //1.开启json数据格式的自动转换，在配置类中开启@EnableWebMvc
    //2.使用@RequestBody注解将外部传递的json数组数据映射到形参的保存实体类对象的集合对象中，要求属性名称一一对应
    @RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<User> list){
        System.out.println("list pojo(json)参数传递 list ==> "+list);
        return "{'module':'list pojo for json param'}";
    }

    //日期参数 http://localhost:80/dataParam?date=2088/08/08&date1=2088-08-18&date2=2088/08/28 8:08:08
    //使用@DateTimeFormat注解设置日期类型数据格式，默认格式yyyy/MM/dd
    @RequestMapping("/dataParam")
    @ResponseBody
    public String dataParam(Date date,
                            @DateTimeFormat(pattern="yyyy-MM-dd") Date date1,
                            @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") Date date2){
        System.out.println("参数传递 date ==> "+date);
        System.out.println("参数传递 date1(yyyy-MM-dd) ==> "+date1);
        System.out.println("参数传递 date2(yyyy/MM/dd HH:mm:ss) ==> "+date2);
        return "{'module':'data param'}";
    }





    /*======================设置响应========================*/

    //响应页面/跳转页面
    //返回值为String类型，设置返回值为页面名称，即可实现页面跳转
    @RequestMapping("/toJumpPage")
    public String toJumpPage(){
        System.out.println("跳转页面");
        return "page.jsp";
    }

    //响应文本数据
    //返回值为String类型，设置返回值为任意字符串信息，即可实现返回指定字符串信息，需要依赖@ResponseBody注解
    @RequestMapping("/toText")
    @ResponseBody
    public String toText(){
        System.out.println("返回纯文本数据");
        return "response text";
    }

    //响应POJO对象
    //返回值为实体类对象，设置返回值为实体类类型，即可实现返回对应对象的json数据，需要依赖@ResponseBody注解和@EnableWebMvc注解
    @RequestMapping("/toJsonPOJO")
    @ResponseBody
    public User toJsonPOJO(){
        System.out.println("返回json对象数据");
        User user = new User();
        user.setName("itcast");
        user.setAge(15);
        return user;
    }

    //响应POJO集合对象
    //返回值为集合对象，设置返回值为集合类型，即可实现返回对应集合的json数组数据，需要依赖@ResponseBody注解和@EnableWebMvc注解
    @RequestMapping("/toJsonList")
    @ResponseBody
    public List<User> toJsonList(){
        System.out.println("返回json集合数据");
        User user1 = new User();
        user1.setName("传智播客");
        user1.setAge(15);

        User user2 = new User();
        user2.setName("黑马程序员");
        user2.setAge(12);

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);

        return userList;
    }


    /*===============================RESTful================================*/


}
