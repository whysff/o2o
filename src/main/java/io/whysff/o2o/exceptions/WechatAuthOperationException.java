package io.whysff.o2o.exceptions;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
public class WechatAuthOperationException extends RuntimeException{

    static final long serialVersionUID = 2614999963654485L;
    public WechatAuthOperationException(String msg) {
        super(msg);
    }

}
