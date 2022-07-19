package io.whysff.o2o.dao;

import io.whysff.o2o.BaseTest;
import io.whysff.o2o.entity.Product;
import io.whysff.o2o.entity.ProductCategory;
import io.whysff.o2o.entity.ProductImg;
import io.whysff.o2o.entity.Shop;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/17
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testAInsertProduct() {

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

    @Test
    public void TestCQueryProductByProductId() {
        long productId = 1;
        // 初始化两个商品详情图实例作为productId为1的商品下的详情图片
        // 批量插入到商品详情图表中
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setPriority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(productId);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setPriority(1);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(productId);
        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int effectedNum = productImgDao.batchInsertProductImg(productImgList);
        assertEquals(2, effectedNum);
        // 查询productId为1的商品信息并校验返回的详情图实例列表size是否为2
        Product product = productDao.queryProductById(productId);
        assertEquals(2, product.getProductImgList().size());
        // 删除新增的这两个商品详情图实例
        effectedNum = productImgDao.deleteProductImgByProductId(productId);
        assertEquals(2, effectedNum);
    }

    @Test
    public void testDUpdateProduct() throws Exception {
        Product product = new Product();
        ProductCategory pc = new ProductCategory();
        Shop shop = new Shop();
        shop.setShopId(1L);
        pc.setProductCategoryId(2L);
        product.setProductId(1L);
        product.setShop(shop);
        product.setProductName("第三个产品");
        product.setProductCategory(pc);
        // 修改productId为1的商品的名称
        // 以及商品类别并校验影响的行数是否为1
        int effectedNum = productDao.updateProduct(product);
        assertEquals(1, effectedNum);
    }
}
