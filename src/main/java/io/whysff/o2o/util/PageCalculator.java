package io.whysff.o2o.util;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/14
 */
public class PageCalculator {
    public static int calculateRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
