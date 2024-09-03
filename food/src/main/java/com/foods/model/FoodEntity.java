package com.foods.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntity {

    @Id
    private String foodId;
    private String FoodName;
    private String description;
    private String price;
    private String Reviews;
}
