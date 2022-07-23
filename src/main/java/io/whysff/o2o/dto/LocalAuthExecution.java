package io.whysff.o2o.dto;

import io.whysff.o2o.entity.LocalAuth;
import io.whysff.o2o.enums.LocalAuthStateEnum;
import lombok.Data;

import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/24
 */
@Data
public class LocalAuthExecution {

    // 结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    private int count;

    private LocalAuth localAuth;

    private List<LocalAuth> localAuthList;

    public LocalAuthExecution() {
    }

    // 失败的构造器
    public LocalAuthExecution(LocalAuthStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // 成功的构造器
    public LocalAuthExecution(LocalAuthStateEnum stateEnum, LocalAuth localAuth) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.localAuth = localAuth;
    }

    // 成功的构造器
    public LocalAuthExecution(LocalAuthStateEnum stateEnum,
                              List<LocalAuth> localAuthList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.localAuthList = localAuthList;
    }
}
