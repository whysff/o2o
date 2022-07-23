package io.whysff.o2o.dao;

import io.whysff.o2o.entity.WechatAuth;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/23
 */
public interface WechatAuthDao {

    /**
     * 通过openId查询对应本平台的微信账号
     *
     * @param openId
     * @return
     */
    WechatAuth queryWechatInfoByOpenId(String openId);

    /**
     * 添加对应本平台的微信账号
     *
     * @param wechatAuth
     * @return
     */
    int insertWechatAuth(WechatAuth wechatAuth);
}
