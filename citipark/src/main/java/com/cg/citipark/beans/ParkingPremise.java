package com.cg.citipark.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parkingpremises")
public class ParkingPremise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parkingPremiseId;
	private String parkingPremiseName;
	private int numberOfParkingFloors;
	
	@OneToOne (targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address premiseAddress;
	
	public ParkingPremise() {
	}

	public ParkingPremise(String parkingPremiseName, int numberOfParkingFloors, Address premiseAddress) {
		super();
		this.parkingPremiseName = parkingPremiseName;
		this.numberOfParkingFloors = numberOfParkingFloors;
		this.premiseAddress = premiseAddress;
	}

	public int getParkingPremiseId() {
		return parkingPremiseId;
	}

	public void setParkingPremiseId(int parkingPremiseId) {
		this.parkingPremiseId = parkingPremiseId;
	}

	public String getParkingPremiseName() {
		return parkingPremiseName;
	}

	public void setParkingPremiseName(String parkingPremiseName) {
		this.parkingPremiseName = parkingPremiseName;
	}

	public int getNumberOfParkingFloors() {
		return numberOfParkingFloors;
	}

	public void setNumberOfParkingFloors(int numberOfParkingFloors) {
		this.numberOfParkingFloors = numberOfParkingFloors;
	}

	public Address getPremiseAddress() {
		return premiseAddress;
	}

	public void setPremiseAddress(Address premiseAddress) {
		this.premiseAddress = premiseAddress;
	}
	
}