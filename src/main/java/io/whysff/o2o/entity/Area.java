package io.whysff.o2o.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Area {
    // ID
    private Integer areaId;
    // 名称
    private String areaName;
    // 权重
    private Integer priority;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date lastEditTime;
}
