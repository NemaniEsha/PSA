package com.cg.citipark.exceptions;

public class NoSuchParkingPremiseExceptionResponse {

	private String parkingPremiseId;

	public NoSuchParkingPremiseExceptionResponse(String parkingPremiseId) {
		super();
		this.parkingPremiseId = parkingPremiseId;
	}

	public String getParkingPremiseId() {
		return parkingPremiseId;
	}

	public void setParkingPremiseId(String parkingPremiseId) {
		this.parkingPremiseId = parkingPremiseId;
	}
	
	
}