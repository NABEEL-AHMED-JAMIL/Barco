package com.ballistic.barco.domain.rtbrequest;

import java.util.List;

public class Pmp {

    private Integer private_auction;
    private List<Deal> deals;
    private Ext ext;

    public Integer getPrivate_auction() {
        return private_auction;
    }

    public void setPrivate_auction(Integer private_auction) {
        this.private_auction = private_auction;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    public Ext getExt() {
        return ext;
    }

    public void setExt(Ext ext) {
        this.ext = ext;
    }
}
