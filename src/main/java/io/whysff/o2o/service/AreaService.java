package io.whysff.o2o.service;

import io.whysff.o2o.entity.Area;

import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
public interface AreaService {

    public static final  String AREALISTKEY = "arealist";

    /**
     * 获取区域列表，优先从缓存获取
     *
     * @return
     */
    List<Area> getAreaList();
}
