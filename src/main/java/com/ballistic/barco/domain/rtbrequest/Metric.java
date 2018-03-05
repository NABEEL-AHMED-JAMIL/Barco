package com.ballistic.barco.domain.rtbrequest;

public class Metric {

    private String type;
    private String value;
    private String vendor;
    private Ext ext;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }


}
