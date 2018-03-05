package com.ballistic.barco.domain.rtbrequest;

import java.util.List;

public class Deal {

    private String id;
    private Float bidfloor;
    private String bidfloorcur;
    private Integer at;
    private List<String> wseat;
    private List<String> wadomain;
    private Ext ext;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Float getBidfloor() { return bidfloor; }
    public void setBidfloor(Float bidfloor) { this.bidfloor = bidfloor; }

    public String getBidfloorcur() { return bidfloorcur; }
    public void setBidfloorcur(String bidfloorcur) { this.bidfloorcur = bidfloorcur; }

    public Integer getAt() { return at; }
    public void setAt(Integer at) { this.at = at; }

    public List<String> getWseat() { return wseat; }
    public void setWseat(List<String> wseat) { this.wseat = wseat; }

    public List<String> getWadomain() { return wadomain; }
    public void setWadomain(List<String> wadomain) { this.wadomain = wadomain; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }


}
