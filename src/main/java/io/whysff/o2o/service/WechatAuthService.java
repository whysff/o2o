package io.whysff.o2o.service;

import io.whysff.o2o.dto.WechatAuthExecution;
import io.whysff.o2o.entity.WechatAuth;
import io.whysff.o2o.exceptions.WechatAuthOperationException;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/23
 */
public interface WechatAuthService {

    /**
     * 通过openId查找平台对应的微信账号
     *
     * @param openId
     * @return
     */
    WechatAuth getWechatAuthByOpenId(String openId);

    /**
     * 注册本平台的微信账号
     *
     * @param wechatAuth
     * @return
     * @throws WechatAuthOperationException
     */
    WechatAuthExecution register(WechatAuth wechatAuth) throws WechatAuthOperationException;
}
