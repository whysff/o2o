package io.whysff.o2o.service;

import io.whysff.o2o.BaseTest;
import io.whysff.o2o.dto.WechatAuthExecution;
import io.whysff.o2o.entity.PersonInfo;
import io.whysff.o2o.entity.WechatAuth;
import io.whysff.o2o.enums.WechatAuthStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/23
 */
public class WechatAuthServiceTest extends BaseTest {

    @Autowired
    private WechatAuthService wechatAuthService;

    @Test
    public void testRegister() {
        WechatAuth wechatAuth = new WechatAuth();
        PersonInfo personInfo = new PersonInfo();
        String openId = "qwerdf";
        personInfo.setCreateTime(new Date());
        personInfo.setName("测试PersonInfoName");
        personInfo.setUserType(1);
        wechatAuth.setPersonInfo(personInfo);
        wechatAuth.setOpenId(openId);
        wechatAuth.setCreateTime(new Date());
        WechatAuthExecution wae = wechatAuthService.register(wechatAuth);
        assertEquals(WechatAuthStateEnum.SUCCESS.getState(), wae.getState());
        wechatAuth = wechatAuthService.getWechatAuthByOpenId(openId);
        System.out.println(wechatAuth.getPersonInfo().getName());
    }
}
