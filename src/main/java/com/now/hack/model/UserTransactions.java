package com.now.hack.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserTransactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;

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
	 * @return the user
	 */
	public BigInteger getUserId() {
		return userId;
	}

	/**
	 * @param user the user to set
	 */
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	/**
	 * @return the pointsUsed
	 */
	public BigInteger getPointsUsed() {
		return pointsUsed;
	}

	/**
	 * @param pointsUsed the pointsUsed to set
	 */
	public void setPointsUsed(BigInteger pointsUsed) {
		this.pointsUsed = pointsUsed;
	}

	/**
	 * @return the items
	 */
	public String getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(String items) {
		this.items = items;
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the voucherType
	 */
	public String getVoucherType() {
		return voucherType;
	}

	/**
	 * @param voucherType the voucherType to set
	 */
	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

	/**
	 * @return the shippingAddress
	 */
	public String getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "UserTransactions [id=" + id + ", user=" + userId + ", pointsUsed=" + pointsUsed + ", items=" + items
				+ ", transactionDate=" + transactionDate + ", voucherType=" + voucherType + ", shippingAddress="
				+ shippingAddress + "]";
	}

	private BigInteger userId;

	private BigInteger pointsUsed;
	private String items;
	private Date transactionDate;
	private String voucherType;
	private String shippingAddress;
}