package com.kaffotek.nyang.ui.model.response;

import java.util.Date;

import com.kaffotek.nyang.shared.dto.UserDto;

public class MealRest {
	
	private String mealId;
	private String name;
	private String location;
	private String description;
	private String notes;
	private String picture;
	private int qty;
	private boolean isAvailable;
	private Date cookingDate;
	private Date expirationDate;
	private UserDto userDetails;
	
	/**
	 * @return the mealId
	 */
	public String getMealId() {
		return mealId;
	}
	/**
	 * @param mealId the mealId to set
	 */
	public void setMealId(String mealId) {
		this.mealId = mealId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}
	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}
	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	/**
	 * @return the cookingDate
	 */
	public Date getCookingDate() {
		return cookingDate;
	}
	/**
	 * @param cookingDate the cookingDate to set
	 */
	public void setCookingDate(Date cookingDate) {
		this.cookingDate = cookingDate;
	}
	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}
	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	/**
	 * @return the userDetails
	 */
//	public UserDto getUserDetails() {
//		return userDetails;
//	}
	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDto userDetails) {
		this.userDetails = userDetails;
	}
    
	

}
