package io.whysff.o2o.service;

import io.whysff.o2o.dto.ImageHolder;
import io.whysff.o2o.dto.ProductExecution;
import io.whysff.o2o.entity.Product;
import io.whysff.o2o.exceptions.ProductOperationException;

import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/17
 */
public interface ProductService {

    /**
     * 插入商品
     *
     * @param product            商品实体类
     * @param thumbnail          缩略图
     * @param thumbnailName      缩略图名称(封装至ImageHolder)
     * @param productImgHolderList     详情图集合
     * @param productImgNameList 详情图的名称集合(封装至ImageHolder)
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList) throws ProductOperationException;

}
