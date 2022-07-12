package io.whysff.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * 配置spring和junit整合，junit启动时加载springIOC容器
 *
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉Junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {
}
