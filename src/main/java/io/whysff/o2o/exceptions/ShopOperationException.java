package io.whysff.o2o.exceptions;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
public class ShopOperationException extends RuntimeException{

    static final long serialVersionUID = 261486745733939L;
    public ShopOperationException(String msg) {
        super(msg);
    }

}
