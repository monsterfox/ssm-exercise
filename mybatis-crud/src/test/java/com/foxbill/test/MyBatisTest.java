package com.foxbill.test;

import com.foxbill.mapper.BrandMapper;
import com.foxbill.pojo.Brand;
import com.foxbill.pojo.PageBean;
import com.foxbill.service.BrandService;
import com.foxbill.service.impl.BrandServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //接收参数，该id以后需要传递过来
        int id = 1;

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        //方式一 ：接口方法参数使用 @Param 方式调用的方法
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
/*        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        List<Brand> brands = brandMapper.selectByCondition(brand);*/

        //方式三 ：接口方法参数是 map集合对象 方式调用的方法
        Map map = new HashMap();
        map.put("status" , status);
        map.put("companyName", companyName);
        map.put("brandName" , brandName);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        //brand.setStatus(status);
        brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true); //设置自动提交事务，这种情况不需要手动提交事务了
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        brandMapper.add(brand);
        System.out.println(brand.getId());
        //提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机,手机中的战斗机";
        int ordered = 200;
        int id = 5;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        //        brand.setCompanyName(companyName);
        //        brand.setBrandName(brandName);
        //        brand.setDescription(description);
        //        brand.setOrdered(ordered);
        brand.setId(id);

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        int count = brandMapper.update(brand);
        System.out.println(count);
        //提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        //接收参数
        int id = 5;

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        brandMapper.deleteById(id);
        //提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        //接收参数
        int[] ids = {5,7,8};

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4. 执行方法
        brandMapper.deleteByIds(ids);
        //提交事务
        sqlSession.commit();
        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByPage() throws IOException {
        int currentPage = 1;
        int pageSize = 5;

        BrandService brandService = new BrandServiceImpl();
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        System.out.println(pageBean);
    }
}
