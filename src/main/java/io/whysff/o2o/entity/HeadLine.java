package io.whysff.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
@Data
public class HeadLine {
    // 主键ID
    private Long lineId;
    // 头条名字
    private String lineName;
    // 头条链接，点击头条会进入相应链接中
    private String lineLink;
    // 头条图片
    private String lineImg;
    // 权重，越大越排前显示
    private Integer priority;
    // 0.不可用 1.可用
    private Integer enableStatus;
    // 创建时间
    private Date createTime;
    // 最近一次的更新时间
    private Date lastEditTime;

    public HeadLine() {
    }

    public HeadLine(Long lineId, String lineName, String lineLink, String lineImg, Integer priority, Integer enableStatus, Date createTime, Date lastEditTime) {
        this.lineId = lineId;
        this.lineName = lineName;
        this.lineLink = lineLink;
        this.lineImg = lineImg;
        this.priority = priority;
        this.enableStatus = enableStatus;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
    }
}
