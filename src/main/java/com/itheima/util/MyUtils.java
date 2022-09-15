package com.itheima.util;

import lombok.Data;

import javax.xml.ws.Service;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@Data
public class MyUtils {
    private Boolean flag;
    private Object data;
    private String msg;

    public MyUtils(){}

    public MyUtils(boolean flag){
        this.flag=flag;
    }

    public MyUtils(boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }

    public MyUtils(String msg) {
        this.msg = msg;
    }

    public MyUtils(Boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }
}
