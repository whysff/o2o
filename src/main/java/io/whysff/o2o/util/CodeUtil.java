package io.whysff.o2o.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lxstart  Email:liuxuan1021@126.com
 * @create 2022/06/27
 */
public class CodeUtil {


    public static boolean checkVerifyCode(HttpServletRequest request) {

        String verifyCodeExpected = (String) request.getSession()
                .getAttribute(Constants.KAPTCHA_SESSION_KEY);

        String verifyCodeActual = HttpServletRequestUtil.getString(request,"verifyCodeActual");
        if (verifyCodeActual == null || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}
