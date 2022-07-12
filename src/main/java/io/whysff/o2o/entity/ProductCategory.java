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
public class ProductCategory {
    // 主键ID
    private Long productCategoryId;
    // 该类别是属于哪个店铺的
    private Long shopId;
    // 类别名
    private String productCategoryName;
    // 权重，越大越排前显示
    private Integer priority;
    // 创建时间
    private Date createTime;
}
