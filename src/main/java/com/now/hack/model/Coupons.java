package com.now.hack.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coupons {

	@Override
	public String toString() {
		return "Coupons [id=" + id + ", user=" + userId + ", vehicleId=" + vehicleId + ", qrCode=" + qrCode
				+ ", dateCreated=" + dateCreated + ", expiryDate=" + expiryDate + ", pointValue=" + pointValue
				+ ", Status=" + Status + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;

	private BigInteger userId;

	private String vehicleId;
	private String qrCode;

	private Date dateCreated;
	private Date expiryDate;
	private BigInteger pointValue;
	private String Status;

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
	 * @return the userid
	 */
	public BigInteger getUserId() {
		return userId;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserId(BigInteger userid) {
		this.userId = userid;
	}

	/**
	 * @return the vehicleId
	 */
	public String getVehicleId() {
		return vehicleId;
	}

	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * @return the qrCode
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * @param qrCode the qrCode to set
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the pointValue
	 */
	public BigInteger getPointValue() {
		return pointValue;
	}

	/**
	 * @param pointValue the pointValue to set
	 */
	public void setPointValue(BigInteger pointValue) {
		this.pointValue = pointValue;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}

}
