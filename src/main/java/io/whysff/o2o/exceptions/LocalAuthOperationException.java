package io.whysff.o2o.exceptions;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
public class LocalAuthOperationException extends RuntimeException{

    static final long serialVersionUID = 26146666685954485L;
    public LocalAuthOperationException(String msg) {
        super(msg);
    }

}
