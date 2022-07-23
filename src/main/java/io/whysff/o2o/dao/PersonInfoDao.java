package io.whysff.o2o.dao;

import io.whysff.o2o.entity.PersonInfo;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/23
 */
public interface PersonInfoDao {

    /**
     * 通过用户id查询用户
     *
     * @param userId
     * @return
     */
    PersonInfo queryPersonInfoById(long userId);

    /**
     * 添加用户信息
     *
     * @param personInfo
     * @return
     */
    int insertPersonInfo(PersonInfo personInfo);
}
