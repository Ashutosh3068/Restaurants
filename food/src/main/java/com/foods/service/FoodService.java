package com.foods.service;

import com.foods.dto.FoodDto;

public interface FoodService {


    FoodDto saveFood(FoodDto foodDto);

    FoodDto getAllFood(FoodDto foodDto);

    FoodDto getFoodById(String foodId);

    FoodDto updateFood(String foodId ,FoodDto foodDto);

    FoodDto deleteFood(String foodId);
}
