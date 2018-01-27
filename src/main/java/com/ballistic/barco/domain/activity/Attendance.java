package com.ballistic.barco.domain.activity;

import com.ballistic.barco.domain.users.Employee;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Lycus 01 on 8/22/2017.
 */
// final class
@Entity
@Table(name = "attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "attend_date")
    private Timestamp attenDate;
    // if the status true/false this will handle the
    // leave operation
    @Column(name = "status")
    private Boolean status;
    @Column(name = "remark")
    private String remark;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Timestamp getAttenDate() { return attenDate; }
    public void setAttenDate(Timestamp attenDate) { this.attenDate = attenDate; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    @Override
    public String toString() {
        return "Attendance{" + "id=" + id + ", attenDate=" + attenDate +
                ", status=" + status + ", remark='" + remark + '\'' +
                ", employee=" + employee + '}';
    }
}
