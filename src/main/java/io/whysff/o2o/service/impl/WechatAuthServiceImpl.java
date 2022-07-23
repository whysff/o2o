package io.whysff.o2o.service.impl;

import io.whysff.o2o.dao.PersonInfoDao;
import io.whysff.o2o.dao.WechatAuthDao;
import io.whysff.o2o.dto.WechatAuthExecution;
import io.whysff.o2o.entity.PersonInfo;
import io.whysff.o2o.entity.WechatAuth;
import io.whysff.o2o.enums.WechatAuthStateEnum;
import io.whysff.o2o.exceptions.WechatAuthOperationException;
import io.whysff.o2o.service.WechatAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/23
 */
@Service
public class WechatAuthServiceImpl implements WechatAuthService {

    Logger logger = LoggerFactory.getLogger(WechatAuthServiceImpl.class);

    @Autowired
    private WechatAuthDao wechatAuthDao;

    @Autowired
    private PersonInfoDao personInfoDao;

    @Override
    public WechatAuth getWechatAuthByOpenId(String openId) {
        return wechatAuthDao.queryWechatInfoByOpenId(openId);
    }

    @Override
    @Transactional
    public WechatAuthExecution register(WechatAuth wechatAuth) throws WechatAuthOperationException {
        // 空值判断
        if (wechatAuth == null || wechatAuth.getOpenId() == null) {
            return new WechatAuthExecution(WechatAuthStateEnum.NULL_AUTH_INFO);
        }
        try {
            // 设置创建时间
            wechatAuth.setCreateTime(new Date());
            // 如果微信账号里带有用户信息并且用户Id为空，则说明该用户第一次使用平台（且通过微信登录）
            // 则自动创建用户信息
            if (wechatAuth.getPersonInfo() != null && wechatAuth.getPersonInfo().getUserId() == null) {
                try {
                    wechatAuth.getPersonInfo().setCreateTime(new Date());
                    wechatAuth.getPersonInfo().setEnableStatus(1);
                    PersonInfo personInfo = wechatAuth.getPersonInfo();
                    int effectedNum = personInfoDao.insertPersonInfo(personInfo);
                    wechatAuth.setPersonInfo(personInfo);
                    if (effectedNum <= 0) {
                        throw new WechatAuthOperationException("添加用户信息失败");
                    }
                } catch (Exception e) {
                    logger.error("insertPersonInfo error:" + e.toString());
                    throw  new WechatAuthOperationException("insertPersonInfo error:" + e.getMessage());
                }
            }
            // 创建专属与本平台的微信账号
            int effectedNum = wechatAuthDao.insertWechatAuth(wechatAuth);
            if (effectedNum <= 0) {
                throw new WechatAuthOperationException("账号创建失败");
            } else {
                return new WechatAuthExecution(WechatAuthStateEnum.SUCCESS,wechatAuth);
            }
        } catch (Exception e) {
            logger.error("insertPersonInfo error:" + e.toString());
            throw new WechatAuthOperationException("insertPersonInfo error:" + e.getMessage());
        }
    }
}
