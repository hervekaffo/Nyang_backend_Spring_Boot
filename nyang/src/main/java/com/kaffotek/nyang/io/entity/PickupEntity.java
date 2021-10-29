package com.kaffotek.nyang.io.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="pickups")
@JsonIdentityInfo (generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class PickupEntity implements Serializable{

	private static final long serialVersionUID = 5313493413859894404L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id") 
	private long id;
	
	@Column(nullable=false)
	private String pickupId;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date pickupDate;
	
	@Column(nullable=false)
	private Boolean isPicked = false;
	
	@Column
	private int donation;
	
	@Column
	private int rating;
	
	@Column
	private String comments;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity beneficiary;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meal_id", referencedColumnName = "id")
	private MealEntity mealDetails;

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

	/**
	 * @return the beneficiary
	 */
	public UserEntity getBeneficiary() {
		return beneficiary;
	}

	/**
	 * @param beneficiary the beneficiary to set
	 */
	public void setBeneficiary(UserEntity beneficiary) {
		this.beneficiary = beneficiary;
	}

	/**
	 * @return the mealDetails
	 */
	public MealEntity getMealDetails() {
		return mealDetails;
	}

	/**
	 * @param mealDetails the mealDetails to set
	 */
	public void setMealDetails(MealEntity mealDetails) {
		this.mealDetails = mealDetails;
	}
	
	
	
	
	

}
