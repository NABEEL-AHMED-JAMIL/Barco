package com.ballistic.barco.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Created by Nabeel on 1/11/2018.
 */
@Entity
public class Authority implements IAuthority{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private UUID uuid;
    @Size(min = 0, max = 50)
    private String name;

    @Override
    public UUID getUuid() { return uuid; }
    @Override
    public void setUuid(UUID uuid) { this.uuid = uuid; }

    @Override
    public String getName() { return name; }
    @Override
    public void setName(String name) { this.name = name; }
}
