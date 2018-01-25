package com.ballistic.barco.domain.auth;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Nabeel on 1/11/2018.
 */
@Entity
public class Authority implements IAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 0, max = 50)
    @Column(unique = true, nullable = false)
    private String name;

    @Override
    public Long getId() { return id; }
    @Override
    public void setId(Long id) { this.id = id; }

    @Override
    public String getName() { return name; }
    @Override
    public void setName(String name) { this.name = name; }
}
