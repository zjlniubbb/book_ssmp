package com.itheima.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@RestControllerAdvice
public class projectExceptionAdvice {

    @ExceptionHandler
    public MyUtils doException(Exception ex){
        ex.printStackTrace();
        return new MyUtils("服务器故障，请稍后重试！");
    }

}
