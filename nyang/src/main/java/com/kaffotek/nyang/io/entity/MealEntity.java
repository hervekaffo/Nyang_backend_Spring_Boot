package com.kaffotek.nyang.io.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="meals")
@JsonIdentityInfo (generator = ObjectIdGenerators.PropertyGenerator.class, 
property = "id")
public class MealEntity implements Serializable{
	
	private static final long serialVersionUID = 7809200551645852693L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length=30, nullable=false)
	private String mealId;
	
	@Column(nullable=false, length=50)
	private String name;
	
	@Column(nullable=false, length=50)
	private String location;
	
	@Column(nullable=false, length=250)
	private String description;
	
	@Column(nullable=false, length=250)
	private String notes;
	
	@Column(nullable=false, length=200)
	private String picture;
	
	@Column(nullable=false)
	private int qty;
	
	@Column(nullable=false)
	private Boolean isAvailable = true;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date cookingDate;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expirationDate;
	
	@ManyToOne
	@JoinColumn(name="users_id")
	private UserEntity userDetails;
	
//	@OneToOne(mappedBy = "pickups")
//	private PickupEntity pickup;
	
	
	
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
	 * @return the cookingDdate
	 */
	public Date getCookingDate() {
		return cookingDate;
	}

	/**
	 * @param cookingDdate the cookingDdate to set
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
	public UserEntity getUserDetails() {
		return userDetails;
	}



	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserEntity userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @return the isAvailable
	 */
	public Boolean getIsAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

//	/**
//	 * @return the pickup
//	 */
//	public PickupEntity getPickup() {
//		return pickup;
//	}
//
//	/**
//	 * @param pickup the pickup to set
//	 */
//	public void setPickup(PickupEntity pickup) {
//		this.pickup = pickup;
//	}
	
	
	

}
