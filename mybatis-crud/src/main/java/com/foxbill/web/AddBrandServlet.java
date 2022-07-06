package com.foxbill.web;

import com.alibaba.fastjson.JSON;
import com.foxbill.pojo.Brand;
import com.foxbill.service.BrandService;
import com.foxbill.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "AddBrandServlet", value = "/addBrandServlet")
public class AddBrandServlet extends HttpServlet {
    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //2.转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        brandService.add(brand);
        //3. 写数据
        response.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
