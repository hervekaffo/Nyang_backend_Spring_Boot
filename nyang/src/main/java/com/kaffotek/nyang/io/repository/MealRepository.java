package com.kaffotek.nyang.io.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kaffotek.nyang.io.entity.MealEntity;
import com.kaffotek.nyang.io.entity.UserEntity;

@Repository
public interface MealRepository extends PagingAndSortingRepository<MealEntity, Long> {
	
	MealEntity findByMealId(String mealId);
	MealEntity findByCookingDate(Date cookingDate);
	List <MealEntity> findByUserDetails(UserEntity user);
	List <MealEntity> findByLocation(String location);
	
	@Query(value="select * from Meals m where m.IS_AVAILABLE = 'true'", 
			countQuery="select count(*) from Meals m where m.IS_AVAILABLE = 'true'", 
			nativeQuery = true)
	Page<MealEntity> findAllMealsAvailable( Pageable pageableRequest );
	
	@Query(value="select * from meals m where m.users_id = :userId",nativeQuery=true)
	List<MealEntity> findMealsForUser(@Param("userId") Long userId);
}
