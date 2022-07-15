package io.whysff.o2o.dao;

import io.whysff.o2o.BaseTest;
import io.whysff.o2o.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void testBatchInsertProductCategory() {

        List<ProductCategory> productCategoryList = new ArrayList<>();
        ProductCategory pc1 = new ProductCategory();
        pc1.setPriority(10);
        pc1.setProductCategoryName("测试商品类别1");
        pc1.setShopId(6L);
        ProductCategory pc2 = new ProductCategory();
        pc2.setPriority(11);
        pc2.setProductCategoryName("测试商品类别2");
        pc2.setShopId(6L);
        ProductCategory pc3 = new ProductCategory();
        pc3.setPriority(12);
        pc3.setProductCategoryName("测试商品类别3");
        pc3.setShopId(6L);
        productCategoryList.add(pc1);
        productCategoryList.add(pc2);
        productCategoryList.add(pc3);

        int count = productCategoryDao.batchInsertProductCategory(productCategoryList);
        assertEquals(3,count);
    }
}
