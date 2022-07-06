package com.foxbill.web;

import com.foxbill.pojo.Brand;
import com.foxbill.service.BrandService;
import com.foxbill.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectAllBrandsServlet", value = "/selectAllBrandsServlet")
public class SelectAllBrandsServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用service查询
        List<Brand> brands = brandService.selectAll();
        request.setAttribute("brands",brands);
        request.getRequestDispatcher("brand-bootstrap.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
