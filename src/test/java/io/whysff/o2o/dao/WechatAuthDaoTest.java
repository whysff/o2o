package io.whysff.o2o.dao;

import io.whysff.o2o.BaseTest;
import io.whysff.o2o.entity.PersonInfo;
import io.whysff.o2o.entity.WechatAuth;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/23
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WechatAuthDaoTest extends BaseTest {

    @Autowired
    private WechatAuthDao wechatAuthDao;

    @Test
    public void testBQueryWechatInfoByOpenId() {
        WechatAuth wechatAuth = wechatAuthDao.queryWechatInfoByOpenId("asdfghjk");
        System.out.println("wechatAuth = " + wechatAuth);
    }

    @Test
    public void testAInsertWechatAuth() {
        WechatAuth wechatAuth = new WechatAuth();
        wechatAuth.setCreateTime(new Date());
        wechatAuth.setOpenId("asdfghjk");
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);
        wechatAuth.setPersonInfo(personInfo);
        int effectedNum = wechatAuthDao.insertWechatAuth(wechatAuth);
        assertEquals(1,effectedNum);
    }



}
