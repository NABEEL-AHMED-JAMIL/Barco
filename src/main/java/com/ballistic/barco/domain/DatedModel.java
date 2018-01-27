package com.ballistic.barco.domain;


import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Nabeel on 1/25/2018.
 */
// final class
@MappedSuperclass
public class DatedModel implements Serializable{

    @Column( name = "created_at" )
    private Timestamp createdAt;
    @Column( name = "updated_at" )
    private Timestamp updatedAt;


    public DatedModel() {super();}
    public DatedModel(Timestamp createdAt, Timestamp updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }

    @PrePersist
    @PreUpdate
    public void preSave() { preSaveImpl(); }
    protected void preSaveImpl() {
        Timestamp now = new Timestamp(new DateTime().getMillis());
        if ( getCreatedAt() == null ) {
            setCreatedAt( now );
        }
        setUpdatedAt( now );
    }

    @Override
    public String toString() {
        return "DatedModel{" + "createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
}

