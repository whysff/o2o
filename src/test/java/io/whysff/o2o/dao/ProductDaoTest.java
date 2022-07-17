package io.whysff.o2o.dao;

import io.whysff.o2o.BaseTest;
import io.whysff.o2o.entity.Product;
import io.whysff.o2o.entity.ProductCategory;
import io.whysff.o2o.entity.ProductImg;
import io.whysff.o2o.entity.Shop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/17
 */
public class ProductDaoTest extends BaseTest {
    @Autowired
    private ProductDao productDao;

    @Test
    public void testInsertProduct() {

        Shop shop = new Shop();
        shop.setShopId(1L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(1L);

        Product product = new Product();
        product.setProductName("测试商品");
        product.setProductDesc("测试描述");
        product.setImgAddr("测试地址");
        product.setPriority(1);
        product.setCreateTime(new Date());
        product.setLastEditTime(new Date());
        product.setEnableStatus(1);
        product.setShop(shop);
        product.setProductCategory(pc);

        int effectedNum = productDao.insertProduct(product);
        assertEquals(1,effectedNum);

    }
}
