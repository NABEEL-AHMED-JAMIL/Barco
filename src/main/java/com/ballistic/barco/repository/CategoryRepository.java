package com.ballistic.barco.repository;

import com.ballistic.barco.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 1/28/2018.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
