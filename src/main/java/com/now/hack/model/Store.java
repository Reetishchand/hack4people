package com.now.hack.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;

	private String imageURL;
	private String description;
	private String name;
	private BigInteger pointsToRedeem;
	private BigInteger quantityInStock;

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
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
	 * @return the pointsToRedeem
	 */
	public BigInteger getPointsToRedeem() {
		return pointsToRedeem;
	}

	/**
	 * @param pointsToRedeem the pointsToRedeem to set
	 */
	public void setPointsToRedeem(BigInteger pointsToRedeem) {
		this.pointsToRedeem = pointsToRedeem;
	}

	/**
	 * @return the quantityInStock
	 */
	public BigInteger getQuantityInStock() {
		return quantityInStock;
	}

	/**
	 * @param quantityInStock the quantityInStock to set
	 */
	public void setQuantityInStock(BigInteger quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", pointsToRedeem=" + pointsToRedeem + ", quantityInStock="
				+ quantityInStock + ", imageURL=" + imageURL + ", description=" + description + "]";
	}

}
