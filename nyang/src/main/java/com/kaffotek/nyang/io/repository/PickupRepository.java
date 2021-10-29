package com.kaffotek.nyang.io.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kaffotek.nyang.io.entity.PickupEntity;
import com.kaffotek.nyang.io.entity.UserEntity;

@Repository
public interface PickupRepository extends PagingAndSortingRepository<PickupEntity, Long>{
	
	PickupEntity findByPickupId(String pickupId);
	List<PickupEntity> findByBeneficiary(UserEntity user);
	
	@Query(value="select * from pickups p where p.user_id = :userId",nativeQuery=true)
	List<PickupEntity> findPickupsForUser(@Param("userId") Long userId);
}
