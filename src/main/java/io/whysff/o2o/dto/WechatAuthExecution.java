package io.whysff.o2o.dto;

import io.whysff.o2o.entity.ProductCategory;
import io.whysff.o2o.entity.WechatAuth;
import io.whysff.o2o.enums.ProductCategoryStateEnum;
import io.whysff.o2o.enums.WechatAuthStateEnum;
import lombok.Data;

import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/15
 */
@Data
public class WechatAuthExecution {

    // 结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    private int count;

    private WechatAuth wechatAuth;

    private List<WechatAuth> wechatAuthList;

    public WechatAuthExecution() {
    }

    // 失败的构造器
    public WechatAuthExecution(WechatAuthStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // 成功的构造器
    public WechatAuthExecution(WechatAuthStateEnum stateEnum, WechatAuth wechatAuth) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.wechatAuth = wechatAuth;
    }

    // 成功的构造器
    public WechatAuthExecution(WechatAuthStateEnum stateEnum,
                               List<WechatAuth> wechatAuthList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.wechatAuthList = wechatAuthList;
    }
}
