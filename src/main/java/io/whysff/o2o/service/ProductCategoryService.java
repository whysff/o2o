package io.whysff.o2o.service;

import io.whysff.o2o.dto.ProductCategoryExecution;
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
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
            throws ProductCategoryOperationException;

    /**
     * 将此类别下的商品里的类别id置空，再删除掉该商品类别
     *
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
            throws ProductCategoryOperationException;
}
