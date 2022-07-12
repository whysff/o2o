package io.whysff.o2o.dao;

import io.whysff.o2o.BaseTest;
import io.whysff.o2o.entity.Area;
import io.whysff.o2o.entity.PersonInfo;
import io.whysff.o2o.entity.Shop;
import io.whysff.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
public class ShopDaoTest extends BaseTest {

    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);
        Area area = new Area();
        area.setAreaId(1);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setArea(area);
        shop.setShopAddr("随便一个地址");
        shop.setShopName("新建店铺");
        shop.setShopDesc("测试描述");
        shop.setCreateTime(new Date());
        shop.setPriority(10);
        shop.setEnableStatus(0);
        shop.setAdvice("店铺审核中");

        int count = shopDao.insertShop(shop);
        assertEquals(1,count);
    }

    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();

        shop.setShopId(1L);

        shop.setShopAddr("随便一个地址+++++");
        shop.setShopName("新建店铺");
        shop.setShopDesc("测试描述+++++");
        shop.setLastEditTime(new Date());
        shop.setPriority(10);
        shop.setEnableStatus(1);
        shop.setAdvice("店铺审核中");

        int count = shopDao.updateShop(shop);
        assertEquals(1,count);
    }
}
