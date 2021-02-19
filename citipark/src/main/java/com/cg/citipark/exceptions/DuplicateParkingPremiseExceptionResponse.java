package com.cg.citipark.exceptions;

public class DuplicateParkingPremiseExceptionResponse {

	private String parkingPremiseId;

	public DuplicateParkingPremiseExceptionResponse(String parkingPremiseId) {
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