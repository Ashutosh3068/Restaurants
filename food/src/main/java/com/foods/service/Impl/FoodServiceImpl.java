package com.foods.service.Impl;

import com.foods.Repository.FoodRepository;
import com.foods.dto.FoodDto;
import com.foods.exception.FoodNotFoundException;
import com.foods.model.FoodEntity;
import com.foods.service.FoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private ModelMapper modelMapper;

    public FoodDto entityToDto(FoodEntity foodEntity){
        return modelMapper.map(foodEntity, FoodDto.class);
    }

    public FoodEntity dtoToEntity(FoodDto foodDto){
        return modelMapper.map(foodDto, FoodEntity.class);
    }

    @Autowired
    private FoodRepository foodRepository;
    @Override
    public FoodDto saveFood(FoodDto foodDto) {
        String id = UUID.randomUUID().toString();
        FoodEntity entity = dtoToEntity(foodDto);
        entity.setFoodId(id);
        FoodEntity save = foodRepository.save(entity);
        FoodDto dto = entityToDto(save);
        return dto;
    }

    @Override
    public FoodDto getAllFood(FoodDto foodDto) {
        List<FoodEntity> all = foodRepository.findAll();
        return (FoodDto) all.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public FoodDto getFoodById(String foodId) {
        Optional<FoodEntity> foodEntity = foodRepository.findById(foodId);
        if(foodEntity.isPresent()){
            return entityToDto(foodEntity.get());
        }
        return null;
    }

    @Override
    public FoodDto updateFood(String foodId, FoodDto foodDto) {
        FoodEntity foodEntity = foodRepository.findById(foodId).orElseThrow(
                () -> new FoodNotFoundException("Food with ID: " + foodId + " not found"));
       foodEntity.setFoodName(foodDto.getName());
        // Update other fields as needed
        FoodEntity updatedEntity = foodRepository.save(foodEntity);
        return entityToDto(updatedEntity);
    }

    @Override
    public FoodDto deleteFood(String foodId) {
        FoodEntity foodEntity = foodRepository.findById(foodId)
                .orElseThrow(() -> new FoodNotFoundException("Food with ID: " + foodId + " not found"));
        foodRepository.deleteById(foodId);
        return entityToDto(foodEntity);
    }
}
