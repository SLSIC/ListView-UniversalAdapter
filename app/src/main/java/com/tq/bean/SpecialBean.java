package com.tq.bean;

/**
 * Created by LB
 * E-mail：libao@ranshine.net
 * Time: 2017/4/14
 * Desc:
 */

public class SpecialBean {
    private String title;
    private String desc;
    private String time;

    public SpecialBean() {
    }

    public SpecialBean(String title, String desc, String time) {
        this.title = title;
        this.desc = desc;
        this.time = time;
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

    @Override
    public String toString() {
        return "SpecialBean{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
