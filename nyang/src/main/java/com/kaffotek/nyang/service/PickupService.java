package com.kaffotek.nyang.service;

import java.util.List;

import com.kaffotek.nyang.io.entity.PickupEntity;
import com.kaffotek.nyang.shared.dto.PickupDto;

public interface PickupService {
	
	PickupDto getPickup(String pickupId);
	
	PickupDto updatePickup(String pickupId, PickupDto pickup);
	void deletePickup(String pickupId);
	List<PickupDto> getPickups(int page, int limit);
	void createPickup(PickupEntity pickup, String pickupId);
	PickupDto createPickup(PickupDto pickup) throws Exception;
	List <PickupDto> getPickupsByUser(String userId) throws Exception;


}
