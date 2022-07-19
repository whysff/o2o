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
     * 通过商品Id查询唯一的商品信息
     *
     * @param productId
     * @return
     */
    Product getProductById(long productId);

    /**
     * 添加商品信息以及图片处理
     *
     * @param product            商品实体类
     * @param thumbnail          缩略图
     * @param thumbnailName      缩略图名称(封装至ImageHolder)
     * @param productImgHolderList     详情图集合
     * @param productImgNameList 详情图的名称集合(封装至ImageHolder)
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
            throws ProductOperationException;

    /**
     * 修改商品信息以及图片处理
     *
     * @param product
     * @param thumbnail
     * @param productImgHolderList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
            throws ProductOperationException;
}
