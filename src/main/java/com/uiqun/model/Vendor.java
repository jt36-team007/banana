package com.uiqun.model;

public class Vendor {
    private int vid;//供应商id
    private int uid;//用户id
    private String co;//公司名称
    private String flevel;//一级分类
    private String slevel;//二级分类
    private String tlevel;//三级分类
    private String website1;//链接地址1
    private String website2;//链接地址2

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getFlevel() {
        return flevel;
    }

    public void setFlevel(String flevel) {
        this.flevel = flevel;
    }

    public String getSlevel() {
        return slevel;
    }

    public void setSlevel(String slevel) {
        this.slevel = slevel;
    }

    public String getTlevel() {
        return tlevel;
    }

    public void setTlevel(String tlevel) {
        this.tlevel = tlevel;
    }

    public String getWebsite1() {
        return website1;
    }

    public void setWebsite1(String website1) {
        this.website1 = website1;
    }

    public String getWebsite2() {
        return website2;
    }

    public void setWebsite2(String website2) {
        this.website2 = website2;
    }
}
