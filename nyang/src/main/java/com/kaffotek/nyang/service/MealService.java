package com.kaffotek.nyang.service;

import java.util.List;

import com.kaffotek.nyang.io.entity.MealEntity;
import com.kaffotek.nyang.shared.dto.MealDto;

public interface MealService {
	
	MealDto getMeal(String mealId);
	
	MealDto updateMeal(String mealId, MealDto meal);
	void deleteMeal(String mealId);
	List<MealDto> getMeals(int page, int limit);
	void createMeal(MealEntity meal, String userId);
	//void uploadPhoto (String photo);
	
	List <MealDto> getMealsByUser(String userId);
	List <MealDto> getMealsByLocation(String location);

}
