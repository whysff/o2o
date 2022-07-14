package io.whysff.o2o.dao;

import io.whysff.o2o.entity.Shop;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
public interface ShopDao {

    /**
     * 根据shopId查询店铺
     *
     * @param shopId
     * @return shop
     */
    Shop queryByShopId(Long shopId);

    /**
     * 新增店铺
     *
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺
     *
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

}
