package com.ballistic.barco.repository;

import com.ballistic.barco.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 1/11/2018.
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
