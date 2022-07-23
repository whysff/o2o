package io.whysff.o2o.service.impl;

import io.whysff.o2o.dao.PersonInfoDao;
import io.whysff.o2o.entity.PersonInfo;
import io.whysff.o2o.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/23
 */
@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    @Autowired
    private PersonInfoDao personInfoDao;

    @Override
    public PersonInfo getPersonInfoById(long userId) {
        return personInfoDao.queryPersonInfoById(userId);
    }
}
