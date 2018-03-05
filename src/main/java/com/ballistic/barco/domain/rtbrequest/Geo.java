package com.ballistic.barco.domain.rtbrequest;

public class Geo {

    private Float lat;
    private Float lon;
    private Integer type;
    private Integer accuracy;
    private Integer lastfix;
    private Integer ipservice;
    private String country;
    private String region;
    private String regionfipsh104;
    private String metro;
    private String city;
    private String zip;
    private Integer utcoffset;
    private Ext ext;

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getLastfix() {
        return lastfix;
    }

    public void setLastfix(Integer lastfix) {
        this.lastfix = lastfix;
    }

    public Integer getIpservice() {
        return ipservice;
    }

    public void setIpservice(Integer ipservice) {
        this.ipservice = ipservice;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionfipsh104() {
        return regionfipsh104;
    }

    public void setRegionfipsh104(String regionfipsh104) {
        this.regionfipsh104 = regionfipsh104;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getUtcoffset() {
        return utcoffset;
    }

    public void setUtcoffset(Integer utcoffset) {
        this.utcoffset = utcoffset;
    }

    public Ext getExt() {
        return ext;
    }

    public void setExt(Ext ext) {
        this.ext = ext;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
