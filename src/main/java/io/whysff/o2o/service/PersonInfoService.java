package io.whysff.o2o.service;

import io.whysff.o2o.entity.PersonInfo;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/23
 */
public interface PersonInfoService {

    /**
     * 根据用户Id获取PersonInfo信息
     *
     * @param userId
     * @return
     */
    PersonInfo getPersonInfoById(long userId);
}
