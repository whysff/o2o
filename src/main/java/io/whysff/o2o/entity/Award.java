package io.whysff.o2o.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//奖品
public class Award {
    // 主键Id
    private Long awardId;
    // 奖品名
    private String awardName;
    // 奖品描述
    private String awardDesc;
    // 奖品图片地址
    private String awardImg;
    // 需要多少积分去兑换
    private Integer point;
    // 权重，越大越排前显示
    private Integer priority;
    // 创建时间
    private Date createTime;
    // 最近一次的更新时间
    private Date lastEditTime;
    // 可用状态 0.不可用 1.可用
    private Integer enableStatus;
    // 属于哪个店铺
    private Long shopId;
}
