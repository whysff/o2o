package io.whysff.o2o.service.impl;

import io.whysff.o2o.dao.ProductCategoryDao;
import io.whysff.o2o.entity.ProductCategory;
import io.whysff.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<ProductCategory> getProductCategoryList(Long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }
}
