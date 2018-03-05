package com.ballistic.barco.domain.rtbrequest;

import java.util.List;

public class Video {

    private List<String> mimes;
    private Integer minduration;
    private Integer maxduration;
    private List<Integer> protocols;
    private Integer protocol;
    private Integer w;
    private Integer h;
    private Integer startdelay;
    private Integer placement;
    private Integer linearity;
    private Integer skip;
    private Integer skipmin;
    private Integer skipafter;
    private Integer sequence;
    private List<Integer> battr;
    private Integer maxextended;
    private Integer minbitrate;
    private Integer maxbitrate;
    private Integer boxingallowed;
    private List<Integer> playbackmethod;
    private Integer playbackend;
    private List<Integer> delivery;
    private Integer pos;
    private List<Banner> companionad;
    private List<Integer> api;
    private List<Integer> companiontype;
    private Ext ext;

    public List<String> getMimes() { return mimes; }
    public void setMimes(List<String> mimes) { this.mimes = mimes; }

    public Integer getMinduration() { return minduration; }
    public void setMinduration(Integer minduration) { this.minduration = minduration; }

    public Integer getMaxduration() { return maxduration; }
    public void setMaxduration(Integer maxduration) { this.maxduration = maxduration; }

    public List<Integer> getProtocols() { return protocols; }
    public void setProtocols(List<Integer> protocols) { this.protocols = protocols; }

    public Integer getProtocol() { return protocol; }
    public void setProtocol(Integer protocol) { this.protocol = protocol; }

    public Integer getW() { return w; }
    public void setW(Integer w) { this.w = w; }

    public Integer getH() { return h; }
    public void setH(Integer h) { this.h = h; }

    public Integer getStartdelay() { return startdelay; }
    public void setStartdelay(Integer startdelay) { this.startdelay = startdelay; }

    public Integer getPlacement() { return placement; }
    public void setPlacement(Integer placement) { this.placement = placement; }

    public Integer getLinearity() { return linearity; }
    public void setLinearity(Integer linearity) { this.linearity = linearity; }

    public Integer getSkip() { return skip; }
    public void setSkip(Integer skip) { this.skip = skip; }

    public Integer getSkipmin() { return skipmin; }
    public void setSkipmin(Integer skipmin) { this.skipmin = skipmin; }

    public Integer getSkipafter() { return skipafter; }
    public void setSkipafter(Integer skipafter) {
        this.skipafter = skipafter;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public List<Integer> getBattr() {
        return battr;
    }

    public void setBattr(List<Integer> battr) {
        this.battr = battr;
    }

    public Integer getMaxextended() {
        return maxextended;
    }

    public void setMaxextended(Integer maxextended) {
        this.maxextended = maxextended;
    }

    public Integer getMinbitrate() {
        return minbitrate;
    }

    public void setMinbitrate(Integer minbitrate) {
        this.minbitrate = minbitrate;
    }

    public Integer getMaxbitrate() {
        return maxbitrate;
    }

    public void setMaxbitrate(Integer maxbitrate) {
        this.maxbitrate = maxbitrate;
    }

    public Integer getBoxingallowed() {
        return boxingallowed;
    }

    public void setBoxingallowed(Integer boxingallowed) {
        this.boxingallowed = boxingallowed;
    }

    public List<Integer> getPlaybackmethod() {
        return playbackmethod;
    }

    public void setPlaybackmethod(List<Integer> playbackmethod) {
        this.playbackmethod = playbackmethod;
    }

    public Integer getPlaybackend() {
        return playbackend;
    }

    public void setPlaybackend(Integer playbackend) {
        this.playbackend = playbackend;
    }

    public List<Integer> getDelivery() {
        return delivery;
    }

    public void setDelivery(List<Integer> delivery) {
        this.delivery = delivery;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public List<Banner> getCompanionad() {
        return companionad;
    }

    public void setCompanionad(List<Banner> companionad) {
        this.companionad = companionad;
    }

    public List<Integer> getApi() {
        return api;
    }

    public void setApi(List<Integer> api) {
        this.api = api;
    }

    public List<Integer> getCompaniontype() {
        return companiontype;
    }

    public void setCompaniontype(List<Integer> companiontype) {
        this.companiontype = companiontype;
    }

    public Ext getExt() {
        return ext;
    }

    public void setExt(Ext ext) {
        this.ext = ext;
    }
}
