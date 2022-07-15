package io.whysff.o2o.exceptions;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/07/12
 */
public class ProductCategoryOperationException extends RuntimeException{

    static final long serialVersionUID = 261486745766939L;
    public ProductCategoryOperationException(String msg) {
        super(msg);
    }

}
