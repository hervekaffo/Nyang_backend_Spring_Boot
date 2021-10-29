package com.kaffotek.nyang.io.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kaffotek.nyang.io.entity.MealEntity;
import com.kaffotek.nyang.io.entity.UserEntity;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MealRepositoryTest {
	
	@Autowired
	MealRepository mealRepository;
	
	@Autowired
	UserRepository userRepository;
	
	static boolean recordsCreated = false;

	@BeforeEach
	void setUp() throws Exception {
		
		if(!recordsCreated) createRecrods();
	}

	

	@Test
	void testGetAvailableMeals() {
		Pageable pageableRequest = PageRequest.of(1, 1);
		Page<MealEntity> page = mealRepository.findAllMealsAvailable(pageableRequest);
		assertNotNull(page);
		
        List<MealEntity> mealEntities = page.getContent();
        assertNotNull(mealEntities);
        assertTrue(mealEntities.size() == 1);
	}
	
	@Test 
	final void testFindMealsForUser()
	{
		Long userId= 19L;
		List<MealEntity> meals = mealRepository.findMealsForUser(userId);
		assertNotNull(meals);
		assertTrue(meals.size() >= 1);
		
		MealEntity meal = meals.get(0);
		//assertTrue(meal.getId()==userId);
	}
	
	private void createRecrods() {
		Date d = new Date();
		// Prepare Meal Entity
		MealEntity mealEntity = new MealEntity();
		mealEntity.setMealId("sdsdsd4455dsh71");
		mealEntity.setName("Herve");
		mealEntity.setLocation("Norman");
		mealEntity.setDescription("Good meal");
		mealEntity.setNotes("Ready to eat");
		mealEntity.setPicture("/images/mealTest");
		mealEntity.setQty(1);
		mealEntity.setIsAvailable(true);
		mealEntity.setCookingDate(d);
		mealEntity.setExpirationDate(d);
		
		// Prepare User Entity
	     UserEntity userEntity = new UserEntity();
	     userEntity.setFirstName("Herve");
	     userEntity.setLastName("kaffo");
	     userEntity.setUserId("dfdfd1555661");
	     userEntity.setEncryptedPassword("dfdf");
	     userEntity.setEmail("test1@test1.com");
	     userEntity.setEmailVerificationStatus(true);
	     
	     userRepository.save(userEntity);
	     
	     mealEntity.setUserDetails(userEntity);
	     
	     mealRepository.save(mealEntity);
	     
	     recordsCreated = true;
		
	}

}
