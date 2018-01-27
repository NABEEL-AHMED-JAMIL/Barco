package com.ballistic.barco.repository;

import com.ballistic.barco.domain.activity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 1/27/2018.
 */
@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
