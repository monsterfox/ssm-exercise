package com.foxbill.web;

import com.alibaba.fastjson.JSON;
import com.foxbill.pojo.Brand;
import com.foxbill.pojo.PageBean;
import com.foxbill.service.BrandService;
import com.foxbill.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "BrandServlet", value = "/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        //1. 调用service查询
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        //2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8"); //告知浏览器响应的数据是什么， 告知浏览器使用什么字符集进行解码
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //2.转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        brandService.add(brand);
        //3. 写数据
        response.getWriter().write("success");
    }
}
