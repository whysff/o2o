package io.whysff.o2o.exceptions;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
public class ShopCategoryOperationException extends RuntimeException{

    static final long serialVersionUID = 2448866254159L;
    public ShopCategoryOperationException(String msg) {
        super(msg);
    }

}
