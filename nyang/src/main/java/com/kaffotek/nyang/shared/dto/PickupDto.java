package com.kaffotek.nyang.shared.dto;

import java.util.Date;

import com.kaffotek.nyang.io.entity.MealEntity;
import com.kaffotek.nyang.io.entity.UserEntity;

public class PickupDto {
	
	private long id;
	private String pickupId;
	private Date pickupDate;
	private Boolean isPicked;
	private int donation;
	private int rating;
	private String comments;
//	private UserEntity beneficiary;
//	private MealEntity mealDetails;
	private String beneficiaryId;
	private String mealId;
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
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
//	/**
//	 * @return the beneficiary
//	 */
//	public UserEntity getBeneficiary() {
//		return beneficiary;
//	}
//	/**
//	 * @param beneficiary the beneficiary to set
//	 */
//	public void setBeneficiary(UserEntity beneficiary) {
//		this.beneficiary = beneficiary;
//	}
//	/**
//	 * @return the mealDetails
//	 */
//	public MealEntity getMealDetails() {
//		return mealDetails;
//	}
//	/**
//	 * @param mealDetails the mealDetails to set
//	 */
//	public void setMealDetails(MealEntity mealDetails) {
//		this.mealDetails = mealDetails;
//	}
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
