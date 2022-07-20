package io.whysff.o2o.dao;

import io.whysff.o2o.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/20
 */
public interface HeadLineDao {

    /**
     * 根据传入的查询条件（头条名查询头条）
     *
     * @param headLineCondition
     * @return
     */
    List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
}
