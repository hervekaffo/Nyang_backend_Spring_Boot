package com.kaffotek.nyang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kaffotek.nyang.io.entity.MealEntity;
import com.kaffotek.nyang.io.entity.UserEntity;
import com.kaffotek.nyang.io.repository.MealRepository;
import com.kaffotek.nyang.io.repository.UserRepository;
import com.kaffotek.nyang.service.MealService;
import com.kaffotek.nyang.shared.Utils;
import com.kaffotek.nyang.shared.dto.MealDto;

@Service
public class MealServiceImpl implements MealService{
	
	@Autowired
	MealRepository mealRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	Utils utils;


	@Override
	public MealDto getMeal(String mealId) {
		MealDto returnValue = new MealDto();
		MealEntity mealEntity = mealRepository.findByMealId(mealId);

		if (mealEntity == null)
			System.out.println("Meal with ID: " + mealId + " not found");

		ModelMapper modelMapper = new ModelMapper();
		returnValue = modelMapper.map(mealEntity, MealDto.class);

		return returnValue;
	}


	@Override
	public MealDto updateMeal(String mealId, MealDto meal) {
		MealDto returnValue = new MealDto();
		
		MealEntity mealEntity = mealRepository.findByMealId(mealId);

		if (mealEntity == null)
			System.out.println("Meal with ID: " + mealId + " not found");
		
		mealEntity.setName(meal.getName());
		mealEntity.setName(meal.getName());
		mealEntity.setLocation(meal.getLocation());
		mealEntity.setDescription(meal.getDescription());
		mealEntity.setNotes(meal.getNotes());
		mealEntity.setPicture(meal.getPicture());
		mealEntity.setAvailable(meal.isAvailable());
		mealEntity.setCookingDate(meal.getCookingDate());
		mealEntity.setExpirationDate(meal.getExpirationDate());
		
		ModelMapper modelMapper = new ModelMapper();

		MealEntity updatedMealDetails = mealRepository.save(mealEntity);
		returnValue = modelMapper.map(updatedMealDetails, MealDto.class);
		
		return returnValue;
	}

	@Override
	public void deleteMeal(String mealId) {
		MealEntity mealEntity = mealRepository.findByMealId(mealId);

		if (mealEntity == null)
			System.out.println("Meal with ID: " + mealId + " not found");
		
		mealRepository.delete(mealEntity);
		
	}

	@Override
	public List<MealDto> getMeals(int page, int limit) {
		List<MealDto> returnValue = new ArrayList<>();
		
		if(page>0) page = page-1;
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<MealEntity> mealsPage = mealRepository.findAll(pageableRequest);
		List<MealEntity> meals = mealsPage.getContent();
		ModelMapper modelMapper = new ModelMapper();
		
		for (MealEntity mealEntity : meals) {
            MealDto mealDto = new MealDto();
			//BeanUtils.copyProperties(userEntity, userDto);
            mealDto = modelMapper.map(mealEntity, MealDto.class);
			returnValue.add(mealDto);
        }
		
		return returnValue;
	}

	@Override
	public void createMeal(MealEntity meal, String userId) {
		
		String publicMealId = utils.generateMealId(30);
		meal.setMealId(publicMealId);
		
		UserEntity userEntity = userRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UsernameNotFoundException("User with ID: " + userId + " not found");
		
		System.out.println(userEntity.getEmail());
		
		//List <MealEntity> mealsToCreate = new ArrayList<>();
		
		meal.setUserDetails(userEntity);
		
		//userEntity.setMeals(mealsToCreate);
		
		mealRepository.save(meal);
		

	}


	@Override
	public List<MealDto> getMealsByUser(String userId) {
		List<MealDto> returnValue = new ArrayList<>();
		
		UserEntity userEntity = userRepository.findByUserId(userId);
		
		if (userEntity == null)
			throw new UsernameNotFoundException("User with ID: " + userId + " not found");
		
		List <MealEntity> meals = mealRepository.findMealsForUser(userEntity.getId());
		ModelMapper modelMapper = new ModelMapper();
		
		for (MealEntity mealEntity : meals) {
            MealDto mealDto = new MealDto();
            mealDto = modelMapper.map(mealEntity, MealDto.class);
			returnValue.add(mealDto);
        }
		
		
		return returnValue;
	}

	@Override
	public List<MealDto> getMealsByLocation(String location) {
		List<MealDto> returnValue = new ArrayList<>();
		
		List <MealEntity> meals = mealRepository.findByLocation(location);
		ModelMapper modelMapper = new ModelMapper();
		
		for (MealEntity mealEntity : meals) {
            MealDto mealDto = new MealDto();
            mealDto = modelMapper.map(mealEntity, MealDto.class);
			returnValue.add(mealDto);
        }
		
		return returnValue;
	}


}
