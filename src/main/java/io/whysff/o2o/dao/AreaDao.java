package io.whysff.o2o.dao;

import io.whysff.o2o.entity.Area;

import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
public interface AreaDao {

    /**
     * 返回区域列表
     * @return areaList
     */
    List<Area> queryArea();
}
