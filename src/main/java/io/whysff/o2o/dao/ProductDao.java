package io.whysff.o2o.dao;

import io.whysff.o2o.entity.Product;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/17
 */
public interface ProductDao {

    /**
     * 通过productId查询唯一的商品信息
     *
     * @param productId
     * @return
     */
    Product queryProductById(long productId);

    /**
     * 插入商品
     *
     * @param product
     * @return
     */
    int insertProduct(Product product);

    /**
     * 更新商品信息
     *
     * @param product
     * @return
     */
    int updateProduct(Product product);
}
