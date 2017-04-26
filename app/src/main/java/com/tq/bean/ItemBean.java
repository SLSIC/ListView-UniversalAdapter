package com.tq.bean;

/**
 * Created by LB
 * E-mail：lb@tqscsoft.com
 * Time: 2017/3/21
 * Desc:
 */

public class ItemBean {
    private String title;
    private String desc;
    private String time;
    private String phone;

    public ItemBean() {
    }

    public ItemBean(String title, String desc, String time, String phone) {
        this.title = title;
        this.desc = desc;
        this.time = time;
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", time='" + time + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
