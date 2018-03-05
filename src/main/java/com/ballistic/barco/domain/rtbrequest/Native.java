package com.ballistic.barco.domain.rtbrequest;

import java.util.List;

public class Native {

    private String request;
    private String ver;
    private Integer api;
    private List<Integer> battr;
    private Ext ext;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public Integer getApi() {
        return api;
    }

    public void setApi(Integer api) {
        this.api = api;
    }

    public List<Integer> getBattr() {
        return battr;
    }

    public void setBattr(List<Integer> battr) {
        this.battr = battr;
    }

    public Ext getExt() {
        return ext;
    }

    public void setExt(Ext ext) {
        this.ext = ext;
    }
}
