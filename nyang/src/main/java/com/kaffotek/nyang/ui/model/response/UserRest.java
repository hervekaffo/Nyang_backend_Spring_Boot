package com.kaffotek.nyang.ui.model.response;

import java.util.List;

public class UserRest {
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String picture;
	private int review;
	private List<AddressesRest> addresses;
	private List<MealRest> meals;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	 * @return the review
	 */
	public int getReview() {
		return review;
	}

	/**
	 * @param review the review to set
	 */
	public void setReview(int review) {
		this.review = review;
	}

	public List<AddressesRest> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressesRest> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the meals
	 */
	public List<MealRest> getMeals() {
		return meals;
	}

	/**
	 * @param meals the meals to set
	 */
	public void setMeals(List<MealRest> meals) {
		this.meals = meals;
	}
	
	

}