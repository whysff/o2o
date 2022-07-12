package io.whysff.o2o.dto;


import io.whysff.o2o.entity.Shop;
import io.whysff.o2o.enums.ShopStateEnum;
import lombok.Data;


import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/06/26
 */
@Data
public class ShopExecution {
    // 结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    // 店铺数量
    private int count;

    // 操作的shop（增删改查店铺的时候用到）
    private Shop shop;

    // shop列表（查询店铺列表的时候使用）
    private List<Shop> shopList;

    public ShopExecution(){}

    /**
     * 店铺操作失败的时候使用的构造器
     * @param stateEnum
     */
    public ShopExecution(ShopStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     * 店铺操作成功的时候使用的构造器
     */
    public ShopExecution(ShopStateEnum stateEnum, Shop shop){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    /**
     * 店铺操作成功的时候使用的构造器
     */
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }
}
