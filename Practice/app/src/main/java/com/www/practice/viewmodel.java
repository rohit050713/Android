package com.www.practice;

import android.widget.ImageView;

public class viewmodel {
    int i1,delete,more;
    String tv;

    public viewmodel(int i1, int delete, int more, String tv) {
        this.i1 = i1;
        this.delete = delete;
        this.more = more;
        this.tv = tv;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public int getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }
}
