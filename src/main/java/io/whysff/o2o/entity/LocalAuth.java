package io.whysff.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
@Data
public class LocalAuth {
    // 主键ID
    private Long localAuthId;
    // 帐号
    private String username;
    // 密码
    private String password;
    // 创建时间
    private Date createTime;
    // 最近一次的更新时间
    private Date lastEditTime;
    // 个人信息，关系为一一对应
    private PersonInfo personInfo;

    public LocalAuth() {
    }

    public LocalAuth(Long localAuthId, String username, String password, Date createTime, Date lastEditTime, PersonInfo personInfo) {
        this.localAuthId = localAuthId;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
        this.personInfo = personInfo;
    }
}
