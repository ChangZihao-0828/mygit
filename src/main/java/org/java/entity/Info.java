package org.java.entity;

import java.io.Serializable;

/**
 * @Auther: 昌子豪
 * @Date: 2019/8/1 15:09
 * @Description: Frighting!!!
 */


public class Info implements Serializable {

    private Integer type=1;

    private String msg;

    private String toUser;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
}
