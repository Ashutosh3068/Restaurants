package com.foods.Repository;

import com.foods.model.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, String> {
}
