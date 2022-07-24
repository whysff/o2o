package io.whysff.o2o.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
//店铺授权
public class ShopAuthMap {
	// 主键Id
	private Long shopAuthId;
	// 职称名
	private String title;
	// 职称符号（可用于权限控制）
	private Integer titleFlag;
	// 授权有效状态，0.无效 1.有效
	private Integer enableStatus;
	// 创建时间
	private Date createTime;
	// 最近一次的更新时间
	private Date lastEditTime;
	// 员工信息实体类
	private PersonInfo employee;
	// 店铺实体类
	private Shop shop;

}
