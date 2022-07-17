package io.whysff.o2o.dao;

import io.whysff.o2o.BaseTest;
import io.whysff.o2o.entity.ProductImg;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/17
 */
public class ProductImgDaoTest extends BaseTest {

    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testBatchInsertProductImg() {
        List<ProductImg> productImgList = new ArrayList<>();
        ProductImg p1 = new ProductImg();
        p1.setImgAddr("test1");
        p1.setImgDesc("测试图片1");
        p1.setPriority(1);
        p1.setCreateTime(new Date());
        p1.setProductId(1L);
        productImgList.add(p1);
        ProductImg p2 = new ProductImg();
        p2.setImgAddr("test2");
        p2.setImgDesc("测试图片2");
        p2.setPriority(2);
        p2.setCreateTime(new Date());
        p2.setProductId(1L);
        productImgList.add(p2);

        int effectedNum = productImgDao.batchInsertProductImg(productImgList);
        assertEquals(2,effectedNum);
    }
}
