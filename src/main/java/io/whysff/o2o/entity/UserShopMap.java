package io.whysff.o2o.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
//顾客店铺积分映射
public class UserShopMap {
	// 主键Id
	private Long userShopId;
	// 创建时间
	private Date createTime;
	// 顾客在该店铺的积分
	private Integer point;
	// 顾客信息实体类
	private PersonInfo user;
	// 店铺信息实体类
	private Shop shop;

}
