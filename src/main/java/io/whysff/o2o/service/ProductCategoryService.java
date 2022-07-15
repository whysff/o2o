package io.whysff.o2o.service;

import io.whysff.o2o.dto.ProductCategoryExection;
import io.whysff.o2o.entity.ProductCategory;
import io.whysff.o2o.exceptions.ProductCategoryOperationException;

import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/15
 */
public interface ProductCategoryService {

    /**
     * 查询指定某一个店铺下的所有商品类别信息
     *
     * @param shopId
     * @return List<ProductCategory>
     */
    List<ProductCategory> getProductCategoryList(Long shopId);

    /**
     * 批量添加商品类别
     *
     * @param productCategoryList
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExection batchAddProductCategory(List<ProductCategory> productCategoryList)
            throws ProductCategoryOperationException;
}
