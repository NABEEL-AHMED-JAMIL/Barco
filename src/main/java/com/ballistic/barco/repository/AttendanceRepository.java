package com.ballistic.barco.repository;

import com.ballistic.barco.domain.activity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 1/27/2018.
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
