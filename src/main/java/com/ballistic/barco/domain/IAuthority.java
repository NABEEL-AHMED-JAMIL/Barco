package com.ballistic.barco.domain;

import java.util.UUID;

/**
 * Created by Nabeel on 1/11/2018.
 */
public interface IAuthority {

    public UUID getUuid();
    public void setUuid(UUID uuid);

    public String getName();
    public void setName(String name);
}
