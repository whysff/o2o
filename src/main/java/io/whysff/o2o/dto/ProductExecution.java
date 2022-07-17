package io.whysff.o2o.dto;


import io.whysff.o2o.entity.Product;
import io.whysff.o2o.entity.Shop;
import io.whysff.o2o.enums.ProductStateEnum;
import io.whysff.o2o.enums.ShopStateEnum;
import lombok.Data;

import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/06/26
 */
@Data
public class ProductExecution {
    // 结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    // 商品数量
    private int count;

    // 操作的product（增删改查店铺的时候用到）
    private Product product;

    // product列表（查询店铺列表的时候使用）
    private List<Product> productList;

    public ProductExecution(){}

    /**
     * 商品操作失败的时候使用的构造器
     * @param stateEnum
     */
    public ProductExecution(ProductStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     * 商品操作成功的时候使用的构造器
     */
    public ProductExecution(ProductStateEnum stateEnum, Product product){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.product = product;
    }

    /**
     * 商品操作成功的时候使用的构造器
     */
    public ProductExecution(ProductStateEnum stateEnum, List<Product> productList){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.productList = productList;
    }
}
