package io.whysff.o2o.service.impl;

import io.whysff.o2o.dao.ProductCategoryDao;
import io.whysff.o2o.dto.ProductCategoryExection;
import io.whysff.o2o.entity.ProductCategory;
import io.whysff.o2o.enums.ProductCategoryStateEnum;
import io.whysff.o2o.exceptions.ProductCategoryOperationException;
import io.whysff.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/15
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    @Transactional
    public List<ProductCategory> getProductCategoryList(Long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }

    @Override
    @Transactional
    public ProductCategoryExection batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException {
        if (productCategoryList != null && productCategoryList.size() > 0) {
            try {
                int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
                if (effectedNum <= 0) {
                    throw new ProductCategoryOperationException("店铺类别创建失败");
                } else {
                    return new ProductCategoryExection(ProductCategoryStateEnum.SUCCESS);
                }
            } catch (Exception e) {
                throw  new ProductCategoryOperationException("batchAddProductCategory error:" + e.getMessage());
            }
        } else {
            return new ProductCategoryExection(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }

    @Override
    @Transactional
    public ProductCategoryExection deleteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException {
        // TODO 将此类别下的商品里的类别id置空
        try {
            int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId,shopId);
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("商品类别删除失败");
            } else {
                return new ProductCategoryExection(ProductCategoryStateEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
        }
    }
}
