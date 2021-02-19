package com.cg.citipark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.citipark.beans.ParkingPremise;
import com.cg.citipark.service.AdminService;
import com.cg.citipark.service.MapValidationErrorService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/parkingPremise")
	public ResponseEntity<?> addParkingPremise(@RequestBody ParkingPremise parkingPremise, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null) 
			return errorMap;
		ParkingPremise premise = adminService.createParkingPremise(parkingPremise);
		return new ResponseEntity<ParkingPremise>(premise, HttpStatus.OK);
	}
	
	@GetMapping("/parkingPremise/{parkingPremiseId}")
	public ResponseEntity<?> getParkingPremiseById(@PathVariable Integer parkingPremiseId) {
		
		ParkingPremise premise = adminService.readParkingPremiseById(parkingPremiseId);
		return new ResponseEntity<ParkingPremise>(premise, HttpStatus.OK);
	}
	
	@GetMapping("/api/parkingPremise/{parkingPremiseName}")
	public List<ParkingPremise> getParkingPremisesByPremiseName(@PathVariable String parkingPremiseName) {
		return adminService.readParkingPremiseByName(parkingPremiseName);
	}
	
	@GetMapping("/parkingPremise/all")
	public List<ParkingPremise> getAllParkingPremises(){
		return adminService.readAllParkingPremises();
	}
	
	@PutMapping("/parkingPremise/update")
	public ParkingPremise updateParkingPremise(@RequestBody ParkingPremise parkingPremise) {
		return adminService.updateParkingPremise(parkingPremise);
	}
	
	@DeleteMapping("/parkingPremise/delete/{parkingPremiseId}")
	public void removeParkingPremise(@PathVariable Integer parkingPremiseId) {
		adminService.deleteParkingPremise(parkingPremiseId);
	}
}
