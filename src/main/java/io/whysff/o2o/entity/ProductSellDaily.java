package io.whysff.o2o.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
//顾客消费的商品映射
public class ProductSellDaily {
	// 哪天的销量，精确到天
	private Date createTime;
	// 销量
	private Integer total;
	// 商品信息实体类
	private Product product;
	// 店铺信息实体类
	private Shop shop;

}
