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
import com.kaffotek.nyang.io.entity.PickupEntity;
import com.kaffotek.nyang.io.entity.UserEntity;
import com.kaffotek.nyang.io.repository.MealRepository;
import com.kaffotek.nyang.io.repository.PickupRepository;
import com.kaffotek.nyang.io.repository.UserRepository;
import com.kaffotek.nyang.service.PickupService;
import com.kaffotek.nyang.shared.Utils;
import com.kaffotek.nyang.shared.dto.PickupDto;

@Service
public class PickupServiceImpl implements PickupService {

	@Autowired
	PickupRepository pickupRepository;

	@Autowired
	MealRepository mealRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;

	@Override
	public PickupDto getPickup(String pickupId) {
		PickupDto returnValue = new PickupDto();
		PickupEntity pickupEntity = pickupRepository.findByPickupId(pickupId);

		if (pickupEntity == null)
			System.out.println("Pickup with ID: " + pickupId + " not found");

		ModelMapper modelMapper = new ModelMapper();
		returnValue = modelMapper.map(pickupEntity, PickupDto.class);

		return returnValue;
	}

	@Override
	public PickupDto updatePickup(String pickupId, PickupDto pickup) {
		//PickupDto returnValue = new PickupDto();
		PickupEntity pickupEntity = pickupRepository.findByPickupId(pickupId);

		if (pickupEntity == null)
			System.out.println("Pickup with ID: " + pickupId + " not found");
		
		pickupEntity.setComments(pickup.getComments());
		pickupEntity.setDonation(pickup.getDonation());
		pickupEntity.setIsPicked(pickup.getIsPicked());
		pickupEntity.setRating(pickup.getRating());

		//ModelMapper modelMapper = new ModelMapper();
		pickupRepository.save(pickupEntity);
		//returnValue = modelMapper.map(pickupEntity, PickupDto.class);

		return pickup;
	}

	@Override
	public void deletePickup(String pickupId) {
		PickupEntity pickupEntity = pickupRepository.findByPickupId(pickupId);

		if (pickupEntity == null)
			System.out.println("Pickup with ID: " + pickupId + " not found");
		
		pickupRepository.delete(pickupEntity);

	}

	@Override
	public List<PickupDto> getPickups(int page, int limit) {
		List<PickupDto> returnValue = new ArrayList<>();
		
		if(page>0) page = page-1;
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<PickupEntity> pickupsPage = pickupRepository.findAll(pageableRequest);
		List<PickupEntity> pickups = pickupsPage.getContent();
		ModelMapper modelMapper = new ModelMapper();
		
		for (PickupEntity pickupEntity : pickups) {
			PickupDto pickupDto = new PickupDto();
			pickupDto = modelMapper.map(pickupEntity, PickupDto.class);
			returnValue.add(pickupDto);
        }
		
		return returnValue;
	}

	@Override
	public void createPickup(PickupEntity pickup, String pickupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PickupDto> getPickupsByUser(String userId) throws Exception{
		List<PickupDto> returnValue = new ArrayList<>();
		
		UserEntity userEntity = userRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UsernameNotFoundException("User with ID: " + userId + " not found");
		
		List <PickupEntity> pickups = pickupRepository.findPickupsForUser(userEntity.getId());
		
		ModelMapper modelMapper = new ModelMapper();
		
		for (PickupEntity pickupEntity : pickups) {
			PickupDto pickupDto = new PickupDto();
			pickupDto = modelMapper.map(pickupEntity, PickupDto.class);
			returnValue.add(pickupDto);
        }
		
		return returnValue;
	}

	@Override
	public PickupDto createPickup(PickupDto pickup) throws Exception {

		UserEntity userEntity = userRepository.findByUserId(pickup.getBeneficiaryId());

		if (userEntity == null)
			throw new UsernameNotFoundException("User with ID: " + pickup.getBeneficiaryId() + " not found");

		MealEntity mealEntity = mealRepository.findByMealId(pickup.getMealId());

		if (mealEntity == null)
			throw new Exception("User with ID: " + pickup.getMealId() + " not found");


		String publicPickupId = utils.generateMealId(30);
		pickup.setPickupId(publicPickupId);
	

		PickupEntity pickupEntity = new PickupEntity();

		pickupEntity.setPickupId(publicPickupId);
		pickupEntity.setBeneficiary(userEntity);
		pickupEntity.setMealDetails(mealEntity);
		pickupEntity.setComments(pickup.getComments());
		pickupEntity.setDonation(pickup.getDonation());
		pickupEntity.setIsPicked(pickup.getIsPicked());
		pickupEntity.setPickupDate(pickup.getPickupDate());
		pickupEntity.setRating(pickup.getRating());
		
		if(mealEntity.getQty() > 0) {
			mealEntity.setQty(mealEntity.getQty()-1);
			
			mealRepository.save(mealEntity);
			
			pickupRepository.save(pickupEntity);
		}else {
			throw new Exception("The meal "+ mealEntity.getName() +" is no longer available");
		}

		return pickup;
	}


}
