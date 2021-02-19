package com.cg.citipark.service;

import java.util.List;

import org.aspectj.lang.NoAspectBoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.citipark.beans.ParkingPremise;
import com.cg.citipark.exceptions.DuplicateParkingPremiseException;
import com.cg.citipark.exceptions.NoSuchParkingPremiseException;
import com.cg.citipark.repository.ParkingPremiseRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private ParkingPremiseRepository parkingPremiseRepository;
	
	
	
	public AdminServiceImpl(ParkingPremiseRepository parkingPremiseRepository) {
		this.parkingPremiseRepository = parkingPremiseRepository;
	}

	@Transactional
	@Override
	public ParkingPremise createParkingPremise(ParkingPremise parkingPremise) {
		try {
			ParkingPremise premise = new ParkingPremise();
			premise.setParkingPremiseId(parkingPremise.getParkingPremiseId());
			return parkingPremiseRepository.save(parkingPremise);
		} catch(Exception e) {
			throw new DuplicateParkingPremiseException("Parking Premise with id: "+parkingPremise.getParkingPremiseId()+" is already exists");
		}
	}

	@Override
	public ParkingPremise readParkingPremiseById(int parkingPremiseId) {
		ParkingPremise premise = parkingPremiseRepository.findById(parkingPremiseId).get();
		if (premise == null) 
			throw new NoSuchParkingPremiseException("Parking Premise with id: "+parkingPremiseId+" does not exists");
		return premise;
	}

	@Override
	public List<ParkingPremise> readParkingPremiseByName(String premiseName) {
		
		return parkingPremiseRepository.findByParkingPremiseName(premiseName);
	}

	@Override
	public List<ParkingPremise> readAllParkingPremises() {
		return parkingPremiseRepository.findAll();
	}

	@Transactional
	@Override
	public ParkingPremise updateParkingPremise(ParkingPremise parkingPremise) {
		ParkingPremise premise1 = parkingPremiseRepository.findById(parkingPremise.getParkingPremiseId()).get();
		if(premise1!= null)
			return parkingPremiseRepository.save(parkingPremise);
		return null;
	}

	@Override
	public void deleteParkingPremise(int parkingPremiseId) {
		ParkingPremise premise = parkingPremiseRepository.findById(parkingPremiseId).get();
		parkingPremiseRepository.delete(premise);
	}
	
	

}