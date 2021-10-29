package com.kaffotek.nyang.ui.model.request;

import java.util.Date;

public class PickupDetailsRequestModel {
	
	private Date pickupDate;
	private Boolean isPicked;
	private int donation;
	private int rating;
	private String comments;
	
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
	
	

}
