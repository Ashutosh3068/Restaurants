package com.foods.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {

    private String name;
    private String description;
    private String price;
    private String Reviews;
    private String messages;

}


