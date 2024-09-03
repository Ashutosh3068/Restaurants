package com.restaurants.repository;

import com.restaurants.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, String> {
}
