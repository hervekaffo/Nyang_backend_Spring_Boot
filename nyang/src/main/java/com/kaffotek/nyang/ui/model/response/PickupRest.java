package com.kaffotek.nyang.ui.model.response;

import java.util.Date;

import com.kaffotek.nyang.io.entity.MealEntity;
import com.kaffotek.nyang.io.entity.UserEntity;

public class PickupRest {
	
	private String pickupId;
	private Date pickupDate;
	private Boolean isPicked;
	private int donation;
	private int rating;
	private String comments;
	private String beneficiaryId;
	private String mealId;
	/**
	 * @return the pickupId
	 */
	public String getPickupId() {
		return pickupId;
	}
	/**
	 * @param pickupId the pickupId to set
	 */
	public void setPickupId(String pickupId) {
		this.pickupId = pickupId;
	}
	/**
	 * @return the pickupDate
	 */
	public Date getPickupDate() {
		return pickupDate;
	}
	/**
	 * @param pickupDate the pickupDate to set
	 */
	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	/**
	 * @return the isPicked
	 */
	public Boolean getIsPicked() {
		return isPicked;
	}
	/**
	 * @param isPicked the isPicked to set
	 */
	public void setIsPicked(Boolean isPicked) {
		this.isPicked = isPicked;
	}
	/**
	 * @return the donation
	 */
	public int getDonation() {
		return donation;
	}
	/**
	 * @param donation the donation to set
	 */
	public void setDonation(int donation) {
		this.donation = donation;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * @return the beneficiaryId
	 */
	public String getBeneficiaryId() {
		return beneficiaryId;
	}
	/**
	 * @param beneficiaryId the beneficiaryId to set
	 */
	public void setBeneficiaryId(String beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
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

	
	
	

}
