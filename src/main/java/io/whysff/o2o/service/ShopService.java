package io.whysff.o2o.service;

import io.whysff.o2o.dto.ShopExecution;
import io.whysff.o2o.entity.Shop;
import io.whysff.o2o.exceptions.ShopOperationException;

import java.io.InputStream;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
public interface ShopService {

    /**
     * 新增店铺
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
