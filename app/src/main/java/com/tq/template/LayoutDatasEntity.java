package com.tq.template;

import java.util.List;

@SuppressWarnings("unused")
public class LayoutDatasEntity {
    private int layoutId;
    private List datas;
    private int[] position = new int[2];

    public LayoutDatasEntity(int layoutId, List datas) {
        this.layoutId = layoutId;
        this.datas = datas;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public List getDatas() {
        return datas;
    }

    public void setDatas(List datas) {
        this.datas = datas;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "LayoutDatasEntity{" +
                "layoutId=" + layoutId +
                ", datas=" + datas +
                '}';
    }
}
