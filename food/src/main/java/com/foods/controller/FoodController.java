package com.foods.controller;

import com.foods.dto.FoodDto;
import com.foods.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/save")
    public ResponseEntity<FoodDto> saveFood(@RequestBody FoodDto foodDto){
      FoodDto SavedDto = foodService.saveFood(foodDto);
        return new ResponseEntity<>(SavedDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<FoodDto> getAllFood(@PathVariable FoodDto foodDto) {
        FoodDto getAll = foodService.getAllFood(foodDto);
        return new ResponseEntity<>(getAll, HttpStatus.CREATED);
    }

    @GetMapping("/get/{foodid}")
    public ResponseEntity<FoodDto> getFoodById(@PathVariable String foodId){
        FoodDto readDto = foodService.getFoodById(foodId);
        return new ResponseEntity<>(readDto, HttpStatus.OK);
    }

    @PutMapping("/update/{foodid}")
    public ResponseEntity<FoodDto> updateFood(@PathVariable String foodId,FoodDto foodDto){
        FoodDto updatedDto = foodService.updateFood(foodId,foodDto);
        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{foodid}")
    public ResponseEntity<FoodDto> deleteFood(@PathVariable String foodId){
        FoodDto deleteDto = foodService.deleteFood(foodId);
        return new ResponseEntity<>(deleteDto, HttpStatus.NO_CONTENT);
    }

}
