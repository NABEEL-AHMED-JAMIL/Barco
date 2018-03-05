package com.ballistic.barco.domain.rtbrequest;

import java.security.SecureRandom;

public class Device {


    private String ua;
    private Geo geo;
    private Integer dnt;
    private Integer lmt;
    private String ip;
    private String ipv6;
    private Integer devicetype;
    private String make;
    private String model;
    private String os;

    private String osv;
    private String hwv;
    private Integer h;
    private Integer w;
    private Integer ppi;
    private Float pxratio;
    private Integer js;
    private Integer geofetch;
    private String flashver;
    private String language;
    private String carrier;
    private String mccmnc;
    private Integer connectiontype;
    private String ifa;
    private String didsha1;
    private String didsha5;
    private String dpidsha1;
    private String macsha1;
    private String macmd5;
    private Ext ext;


    public String getUa() { return ua; }
    public void setUa(String ua) { this.ua = ua; }

    public Geo getGeo() { return geo; }
    public void setGeo(Geo geo) { this.geo = geo; }

    public Integer getDnt() { return dnt; }
    public void setDnt(Integer dnt) { this.dnt = dnt; }

    public Integer getLmt() { return lmt; }
    public void setLmt(Integer lmt) { this.lmt = lmt; }

    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }

    public String getIpv6() { return ipv6; }
    public void setIpv6(String ipv6) { this.ipv6 = ipv6; }

    public Integer getDevicetype() { return devicetype; }
    public void setDevicetype(Integer devicetype) { this.devicetype = devicetype; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }

    public String getOsv() { return osv; }
    public void setOsv(String osv) { this.osv = osv; }

    public String getHwv() { return hwv; }
    public void setHwv(String hwv) { this.hwv = hwv; }

    public Integer getH() { return h; }
    public void setH(Integer h) { this.h = h; }

    public Integer getW() { return w; }
    public void setW(Integer w) { this.w = w; }

    public Integer getPpi() { return ppi; }
    public void setPpi(Integer ppi) { this.ppi = ppi; }

    public Float getPxratio() { return pxratio; }
    public void setPxratio(Float pxratio) { this.pxratio = pxratio; }

    public Integer getJs() { return js; }
    public void setJs(Integer js) { this.js = js; }

    public Integer getGeofetch() { return geofetch; }
    public void setGeofetch(Integer geofetch) { this.geofetch = geofetch; }

    public String getFlashver() { return flashver; }
    public void setFlashver(String flashver) { this.flashver = flashver; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getCarrier() { return carrier; }
    public void setCarrier(String carrier) { this.carrier = carrier; }

    public String getMccmnc() { return mccmnc; }
    public void setMccmnc(String mccmnc) { this.mccmnc = mccmnc; }

    public Integer getConnectiontype() { return connectiontype; }

    public void setConnectiontype(Integer connectiontype) {
        this.connectiontype = connectiontype;
    }

    public String getIfa() {
        return ifa;
    }

    public void setIfa(String ifa) {
        this.ifa = ifa;
    }

    public String getDidsha1() {
        return didsha1;
    }

    public void setDidsha1(String didsha1) {
        this.didsha1 = didsha1;
    }

    public String getDidsha5() {
        return didsha5;
    }

    public void setDidsha5(String didsha5) {
        this.didsha5 = didsha5;
    }

    public String getDpidsha1() {
        return dpidsha1;
    }

    public void setDpidsha1(String dpidsha1) {
        this.dpidsha1 = dpidsha1;
    }

    public String getMacsha1() {
        return macsha1;
    }

    public void setMacsha1(String macsha1) { this.macsha1 = macsha1; }

    public String getMacmd5() { return macmd5; }
    public void setMacmd5(String macmd5) { this.macmd5 = macmd5; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }
}
