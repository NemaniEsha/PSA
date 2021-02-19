package com.cg.citipark.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.citipark.beans.ParkingPremise;

@Service
public interface AdminService {

	public ParkingPremise createParkingPremise(ParkingPremise parkingPremise);
	
	public ParkingPremise readParkingPremiseById(int parkingPremiseId);
	
	public List<ParkingPremise> readParkingPremiseByName(String premiseName);
	
	public List<ParkingPremise> readAllParkingPremises();
	
	public ParkingPremise updateParkingPremise(ParkingPremise parkingPremise);
	
	public void deleteParkingPremise(int parkingPremiseId);
}