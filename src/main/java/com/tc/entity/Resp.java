package com.tc.entity;

import java.io.Serializable;

/**
 * Created by htc on 2017/4/18.
 */
public class Resp implements Serializable{


    private static final long serialVersionUID = 1089693012165128238L;

    //状态
    private Integer status;

    //打印信息
    private String msg;

    //数据
    private Object data;

    public Resp(){
        super();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
