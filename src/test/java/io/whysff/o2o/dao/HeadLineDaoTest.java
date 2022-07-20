package io.whysff.o2o.dao;

import io.whysff.o2o.BaseTest;
import io.whysff.o2o.entity.HeadLine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/20
 */
public class HeadLineDaoTest extends BaseTest {

    @Autowired
    private HeadLineDao headLineDao;

    @Test
    public void testQueryHeadLine() {
        HeadLine headLineCondition = new HeadLine();
        List<HeadLine> headLineList = headLineDao.queryHeadLine(headLineCondition);
        assertEquals(0,headLineList.size());
    }
}
