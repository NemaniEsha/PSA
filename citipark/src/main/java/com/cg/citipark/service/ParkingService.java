package com.cg.citipark.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.citipark.beans.ParkingSlots;
import com.cg.citipark.exceptions.NoSuchParkingSlotException;
import com.cg.citipark.exceptions.ParkingSlotNotAvailableException;

public interface ParkingService {
	public void addSlot(ParkingSlots parkingSlots) throws ParkingSlotNotAvailableException;
	public void deleteSlot(Long parkingSlotId) throws NoSuchParkingSlotException;
	public boolean checkAvailability(LocalDate parkingDate, String parkingTime) ;
	public ParkingSlots getSlotById(long parkingSlotId) throws NoSuchParkingSlotException;
	public List<ParkingSlots> findAllSlots();
}
