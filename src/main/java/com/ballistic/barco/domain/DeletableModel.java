package com.ballistic.barco.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Nabeel on 1/25/2018.
 */
// final class
@MappedSuperclass
public abstract class DeletableModel extends DatedModel implements Serializable {

    @Column( name = "deleted_at" )
    private Timestamp deletedAt;

    public DeletableModel() {}

    public Timestamp getDeletedAt() { return deletedAt; }
    public void setDeletedAt( Timestamp deletedAt ) { this.deletedAt = deletedAt; }
    public boolean isDeleted() { return getDeletedAt() != null; }

}
