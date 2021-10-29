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

import com.kaffotek.nyang.service.PickupService;
import com.kaffotek.nyang.shared.dto.PickupDto;
import com.kaffotek.nyang.ui.model.request.PickupDetailsRequestModel;
import com.kaffotek.nyang.ui.model.response.MealRest;
import com.kaffotek.nyang.ui.model.response.OperationStatusModel;
import com.kaffotek.nyang.ui.model.response.PickupRest;
import com.kaffotek.nyang.ui.model.response.RequestOperationName;
import com.kaffotek.nyang.ui.model.response.RequestOperationStatus;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("pickups") //http://localhost:8080/nyang/pickups 
@CrossOrigin(origins="http://127.0.0.1:3000") 
public class PickupController {
	
	@Autowired
	PickupService pickupService;
	
	//Get all the pickups http://localhost:8080/nyang/pickups (GET)
		@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
		public List<PickupRest> getPickups(@RequestParam(value = "page", defaultValue = "0") int page,
				@RequestParam(value = "limit", defaultValue = "12") int limit) {
			List<PickupRest> returnValue = new ArrayList<>();
			
			List<PickupDto> pickups = pickupService.getPickups(page, limit);
			
			Type listType = new TypeToken<List<PickupRest>>() {
			}.getType();
			returnValue = new ModelMapper().map(pickups, listType);
			
			return returnValue;
		}
		
		//Get a pickup by Id http://localhost:8080/nyang/pickups/:pickupId (GET)
		@ApiOperation(value="The Get Single Meal Details Web Service Endpoint",
				notes="${mealController.GetMeal.ApiOperation.Notes}")
		@GetMapping(path = "/{id}",
				produces = {MediaType.APPLICATION_JSON_VALUE })
		public PickupRest getPickup(@PathVariable String id) {
			PickupRest returnValue = new PickupRest();

			PickupDto pickupDto = pickupService.getPickup(id);
			ModelMapper modelMapper = new ModelMapper();
			returnValue = modelMapper.map(pickupDto, PickupRest.class);

			return returnValue;
		}
		
		//Create a pickup http://localhost:8080/nyang/pickups (POST)
		@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
		public PickupDto createPickup(@RequestBody PickupDto pickupDetails) throws Exception {
				
			PickupDto returnValue = pickupService.createPickup(pickupDetails);
			
			return returnValue;
		}
		
		//Get pickups by user http://localhost:8080/nyang/pickups/user/:userId (GET)
		@GetMapping(path = "/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE })
		public List<PickupDto> getPickupsForUser(@PathVariable String id) throws Exception {
			
			List <PickupDto> returnValue = new ArrayList <>();	
			returnValue = pickupService.getPickupsByUser(id);
			return returnValue;
			
		}
		
		// Update a pickup http://localhost:8080/nyang/pickups/:pickupId (PUT)
		@PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
		public PickupDto updatePickup(@PathVariable String id, @RequestBody PickupDetailsRequestModel pickupDetails){
			//PickupRest returnValue = new PickupRest();
			
			PickupDto pickupDto = new PickupDto();
			ModelMapper modelMapper = new ModelMapper();
			pickupDto = modelMapper.map(pickupDetails, PickupDto.class);
			
			PickupDto updatedPickup = pickupService.updatePickup(id, pickupDto);
			//returnValue = modelMapper.map(updatedPickup, PickupRest.class);
			
			return pickupDto;
		}
		
		// Delete a pickup http://localhost:8080/nyang/pickups/:pickupId(DELETE)
		@DeleteMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE })
		public OperationStatusModel deletePickup(@PathVariable String id) {
			OperationStatusModel returnValue = new OperationStatusModel();
			
			returnValue.setOperationName(RequestOperationName.DELETE.name());
			
			pickupService.deletePickup(id);

			returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
			
			return returnValue;
		}

}
