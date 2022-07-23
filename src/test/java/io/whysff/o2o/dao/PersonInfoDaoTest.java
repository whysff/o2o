package io.whysff.o2o.dao;

import io.whysff.o2o.BaseTest;
import io.whysff.o2o.entity.PersonInfo;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/23
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonInfoDaoTest extends BaseTest {

    @Autowired
    private PersonInfoDao personInfoDao;

    @Test
    public void testBQueryPersonInfoById() {
        PersonInfo personInfo = personInfoDao.queryPersonInfoById(1);
        System.out.println("personInfo = " + personInfo);
    }

    @Test
    public void testAInsertPersonInfo() {
        PersonInfo p1 = new PersonInfo();
        p1.setName("lx");
        p1.setGender("男");
        p1.setUserType(1);
        p1.setCreateTime(new Date());
        p1.setLastEditTime(new Date());
        p1.setEnableStatus(1);
        int effectedNum = personInfoDao.insertPersonInfo(p1);
        assertEquals(1,effectedNum);
    }
}