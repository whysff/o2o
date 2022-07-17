package io.whysff.o2o.exceptions;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
public class ProductOperationException extends RuntimeException{

    static final long serialVersionUID = 889569878555746212L;
    public ProductOperationException(String msg) {
        super(msg);
    }

}
