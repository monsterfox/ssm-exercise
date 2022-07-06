package com.foxbill.service;

import com.foxbill.pojo.Brand;
import com.foxbill.pojo.PageBean;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();
    PageBean<Brand> selectByPage(int page, int pageSize);
}
