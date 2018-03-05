package com.ballistic.barco.domain.rtbrequest;


import java.util.List;

public class Data {

    private String id;
    private String name;
    private List<Segment> segment;
    private Ext ext;


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Segment> getSegment() { return segment; }
    public void setSegment(List<Segment> segment) { this.segment = segment; }

    public Ext getExt() { return ext; }
    public void setExt(Ext ext) { this.ext = ext; }


}
