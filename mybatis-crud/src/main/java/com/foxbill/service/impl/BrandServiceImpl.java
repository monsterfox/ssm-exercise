package com.foxbill.service.impl;

import com.foxbill.mapper.BrandMapper;
import com.foxbill.pojo.Brand;
import com.foxbill.pojo.PageBean;
import com.foxbill.service.BrandService;
import com.foxbill.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4. 调用方法
        List<Brand> brands = mapper.selectAll();

        //5. 释放资源
        sqlSession.close();

        return brands;
    }

    @Override
    public PageBean<Brand> selectByPage(int page, int pageSize) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        PageBean<Brand> pageBean = new PageBean<Brand>();
        //4. 调用方法
        List<Brand> brands = mapper.selectByPage((page-1)*pageSize,pageSize);
        pageBean.setRows(brands);
        int count = mapper.selectTotalCount();
        pageBean.setTotal(count);
        //5. 释放资源
        sqlSession.close();

        return pageBean;
    }
}
