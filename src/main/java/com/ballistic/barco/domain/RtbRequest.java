package com.ballistic.barco.domain;


import com.ballistic.barco.domain.rtbrequest.*;

import java.util.List;


public class RtbRequest {

    private String id;
    private List<Imp> imp;
    private Site site;
    private App app;
    private Device device;
    private User user;
    private Integer test;
    private Integer at;
    private Integer tmax;
    private List<String> wseat;
    private List<String> bseat;
    private Integer allimps;
    private List<String> cur;
    private List<String> wlang;
    private List<String> bcat;
    private List<String> badv;
    private List<String> bapp;
    private Source source;
    private Regs regs;
    private Object ext;


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public List<Imp> getImp() { return imp; }
    public void setImp(List<Imp> imp) { this.imp = imp; }

    public Site getSite() { return site; }
    public void setSite(Site site) { this.site = site; }

    public App getApp() { return app; }
    public void setApp(App app) { this.app = app; }

    public Device getDevice() { return device; }
    public void setDevice(Device device) { this.device = device; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Integer getTest() { return test; }
    public void setTest(Integer test) { this.test = test; }

    public Integer getAt() { return at; }
    public void setAt(Integer at) { this.at = at; }

    public Integer getTmax() { return tmax; }
    public void setTmax(Integer tmax) { this.tmax = tmax; }

    public List<String> getWseat() { return wseat; }
    public void setWseat(List<String> wseat) { this.wseat = wseat; }

    public List<String> getBseat() { return bseat; }
    public void setBseat(List<String> bseat) { this.bseat = bseat; }

    public Integer getAllimps() { return allimps; }
    public void setAllimps(Integer allimps) { this.allimps = allimps; }

    public List<String> getCur() { return cur; }
    public void setCur(List<String> cur) { this.cur = cur; }

    public List<String> getWlang() { return wlang; }
    public void setWlang(List<String> wlang) { this.wlang = wlang; }

    public List<String> getBcat() { return bcat; }
    public void setBcat(List<String> bcat) { this.bcat = bcat; }

    public List<String> getBadv() { return badv; }
    public void setBadv(List<String> badv) { this.badv = badv; }

    public List<String> getBapp() { return bapp; }
    public void setBapp(List<String> bapp) { this.bapp = bapp; }

    public Source getSource() { return source; }
    public void setSource(Source source) { this.source = source; }

    public Regs getRegs() { return regs; }
    public void setRegs(Regs regs) { this.regs = regs; }

    public Object getExt() { return ext; }
    public void setExt(Object ext) { this.ext = ext; }

}
