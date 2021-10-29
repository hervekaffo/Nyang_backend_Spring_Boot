package com.kaffotek.nyang.ui.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaffotek.nyang.io.entity.MealEntity;
import com.kaffotek.nyang.service.MealService;
import com.kaffotek.nyang.shared.dto.MealDto;
import com.kaffotek.nyang.ui.model.request.MealDetailsRequestModel;
import com.kaffotek.nyang.ui.model.response.MealRest;
import com.kaffotek.nyang.ui.model.response.OperationStatusModel;
import com.kaffotek.nyang.ui.model.response.RequestOperationName;
import com.kaffotek.nyang.ui.model.response.RequestOperationStatus;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("meals") //http://localhost:8080/nyang/meals 
@CrossOrigin(origins="http://127.0.0.1:3000") 
public class MealController {
	
	@Autowired
	MealService mealService;
	
	//Get all the meals http://localhost:8080/nyang/meals(GET)
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<MealRest> getMeals(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit) {
		List<MealRest> returnValue = new ArrayList<>();
		
		List<MealDto> meals = mealService.getMeals(page, limit);
		
		Type listType = new TypeToken<List<MealRest>>() {
		}.getType();
		returnValue = new ModelMapper().map(meals, listType);
		
		
		return returnValue;
	}
	
	//Get a meal by Id http://localhost:8080/nyang/meals/:mealId(GET)
	@ApiOperation(value="The Get Single Meal Details Web Service Endpoint",
			notes="${mealController.GetMeal.ApiOperation.Notes}")
	@GetMapping(path = "/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE })
	public MealRest getMeal(@PathVariable String id) {
		MealRest returnValue = new MealRest();

		MealDto mealDto = mealService.getMeal(id);
		ModelMapper modelMapper = new ModelMapper();
		returnValue = modelMapper.map(mealDto, MealRest.class);

		return returnValue;
	}
	
	//Create a meal http://localhost:8080/nyang/meals/userId (POST)
	@PostMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
	public MealDto createMealWithUID(@RequestBody MealEntity mealDetails, @PathVariable String id) throws Exception {
		
		ModelMapper modelMapper = new ModelMapper();
		MealDto mealDto = modelMapper.map(mealDetails, MealDto.class);
			
		mealService.createMeal(mealDetails, id);
		
		return mealDto;
	}
	
	
	// Update a meal http://localhost:8080/nyang/meals/:mealId (PUT)
	@PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
	public MealRest updateMeal(@PathVariable String id, @RequestBody MealDetailsRequestModel mealDetails){
		MealRest returnValue = new MealRest();
		
		MealDto mealDto = new MealDto();
		ModelMapper modelMapper = new ModelMapper();
		mealDto = modelMapper.map(mealDetails, MealDto.class);
		
		MealDto updatedMeal = mealService.updateMeal(id, mealDto);
		returnValue = modelMapper.map(updatedMeal, MealRest.class);
		
		return returnValue;
	}
	
	// Delete a meal http://localhost:8080/nyang/meals/:mealId(DELETE)
	@DeleteMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel deleteMeal(@PathVariable String id) {
		OperationStatusModel returnValue = new OperationStatusModel();
		
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		
		mealService.deleteMeal(id);

		returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		
		return returnValue;
	}
	
	//Get meals by user http://localhost:8080/nyang/meals/user/:userId (GET)
	@GetMapping(path = "/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public List<MealDto> getMealsForUser(@PathVariable String id) {
		
		List <MealDto> returnValue = new ArrayList <>();	
		returnValue = mealService.getMealsByUser(id);
		return returnValue;
		
	}
	
	
	//Get meals by location http://localhost:8080/nyang/meals?location=location (GET)
	@GetMapping(path = "/location", produces = {MediaType.APPLICATION_JSON_VALUE })
	public List<MealDto> getMealsForLoacation(@RequestParam(value="location", required=false) String location) {
		
		List <MealDto> returnValue = new ArrayList <>();
		
		if (location == null) {
			returnValue = mealService.getMeals(0, 12);
		} 
		else{
			returnValue = mealService.getMealsByLocation(location);
		}
		return returnValue;
	}
}
