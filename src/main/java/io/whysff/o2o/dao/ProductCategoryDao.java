package io.whysff.o2o.dao;

import io.whysff.o2o.entity.ProductCategory;

import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/15
 */
public interface ProductCategoryDao {

    /**
     * 通过shop id 查询店铺商品类别
     *
     * @param shopId
     * @return List<ProductCategory>
     */
    List<ProductCategory> queryProductCategoryList(Long shopId);
}
