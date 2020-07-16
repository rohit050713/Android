package com.www.recylerview;

import android.content.Context;

public class model {
    private String tv1;
    private String tv2;
    private String expandable_tv;

    private int images;


    public String getExpandable_tv() {
        return expandable_tv;
    }

    public void setExpandable_tv(String expandable_tv) {
        this.expandable_tv = expandable_tv;
    }

    public model(String tv1, String tv2, int images, String expandable_tv) {
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.images = images;
        this.expandable_tv=expandable_tv;

    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }


}
