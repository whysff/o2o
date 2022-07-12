package io.whysff.o2o.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    // 主键ID
    private Long shopId;
    // 店铺名称
    private String shopName;
    // 店铺简介
    private String shopDesc;
    // 店铺地址
    private String shopAddr;
    // 店铺号码
    private String phone;
    // 店铺门面图片地址
    private String shopImg;
    // 权重，越大越排前显示
    private Integer priority;
    // 创建时间
    private Date createTime;
    // 最近一次更新的时间
    private Date lastEditTime;
    // -1.不可用 0.审核中 1.可用
    private Integer enableStatus;
    // 超级管理员给店家的提醒，包括为什么审核不通过等
    private String advice;

    // 店铺所属区域
    private Area area;
    // 店铺是属于哪个店家的
    private PersonInfo owner;
    // 店铺类别
    private ShopCategory shopCategory;
}
