package io.whysff.o2o.dao;

import io.whysff.o2o.entity.Product;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/17
 */
public interface ProductDao {

    /**
     * 插入商品
     *
     * @param product
     * @return
     */
    int insertProduct(Product product);
}
