package com.ballistic.barco.domain.activity;

import com.ballistic.barco.domain.users.Employee;

import java.sql.Timestamp;

/**
 * Created by Lycus 01 on 8/23/2017.
 */
public class Salary {

    private Long id;
    private Employee employee;
	private Timestamp saleDate;
    private Double salAmount;
    // check pay or not
    private Boolean status;
    // description if any issue
    private String comment;
}
