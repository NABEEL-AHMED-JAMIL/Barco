package com.ballistic.barco.repository;

import com.ballistic.barco.domain.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 1/28/2018.
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
