package io.whysff.o2o.dao;

import io.whysff.o2o.BaseTest;
import io.whysff.o2o.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/15
 */
public class ProductCategoryDaoTest extends BaseTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testQueryProductCategoryList() {
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(1L);
        System.out.println("productCategoryList = " + productCategoryList);
    }
}
