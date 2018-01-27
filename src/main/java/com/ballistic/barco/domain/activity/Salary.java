package com.ballistic.barco.domain.activity;

import com.ballistic.barco.domain.users.Employee;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Lycus 01 on 8/23/2017.
 */
// final class
@Entity
@Table(name = "salarys")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column( name = "sale_date")
	private Timestamp saleDate;
	@Column(name = "salary_amount")
    private Double salAmount;
    // check pay or not
    @Column(name = "status")
    private Boolean status;
    // description if any issue
    @Column(name = "comment")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public Salary() {}
    public Salary(Timestamp saleDate, Double salAmount, Boolean status,
                  String comment, Employee employee) {
        this.saleDate = saleDate;
        this.salAmount = salAmount;
        this.status = status;
        this.comment = comment;
        this.employee = employee;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Timestamp getSaleDate() { return saleDate; }
    public void setSaleDate(Timestamp saleDate) { this.saleDate = saleDate; }

    public Double getSalAmount() { return salAmount; }
    public void setSalAmount(Double salAmount) { this.salAmount = salAmount; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    @Override
    public String toString() {
        return "Salary{" + "id=" + id + ", saleDate=" + saleDate +
                ", salAmount=" + salAmount + ", status=" + status +
                ", comment='" + comment + '\'' + ", employee=" + employee + '}';
    }
}
