package org.java.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: 昌子豪
 * @Date: 2019/7/31 20:18
 * @Description: Frighting!!!
 */


public class Message implements Serializable {

    private String welcome;

    private String msg;

    private List<String> names;

    private Integer type=1;

    private String fromUser;

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setMsg(String msg,String name) {
        this.msg = "<b><span style='color:red'>【"+name+"】</span>说:<span style='color:green'>"+msg+"</span></b>";
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }
}
