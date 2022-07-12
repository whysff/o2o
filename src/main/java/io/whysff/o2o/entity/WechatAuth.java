package io.whysff.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
@Data
public class WechatAuth {
    // 主键ID
    private Long wechatAuthId;
    // 微信获取用户信息的凭证，对于某个公众号具有唯一性
    private String openId;
    // 创建时间
    private Date createTime;
    // 用户信息
    private PersonInfo personInfo;

    public WechatAuth() {
    }

    public WechatAuth(Long wechatAuthId, String openId, Date createTime, PersonInfo personInfo) {
        this.wechatAuthId = wechatAuthId;
        this.openId = openId;
        this.createTime = createTime;
        this.personInfo = personInfo;
    }
}
