package com.cg.citipark.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.citipark.beans.ParkingPremise;
import com.cg.citipark.beans.ParkingSlots;
import com.cg.citipark.exceptions.NoSuchParkingSlotException;
import com.cg.citipark.exceptions.ParkingSlotNotAvailableException;
import com.cg.citipark.repository.ParkingRepository;


@Service
public class ParkingServiceImpl  implements ParkingService{
	@Autowired
	private ParkingRepository parkingRepository;
	
	@Override
	public void addSlot(ParkingSlots parkingSlots) 
	{
		boolean check=checkAvailability(parkingSlots.getParkingDate(), parkingSlots.getParkingTime());
		if(check)
		{
		parkingRepository.save(parkingSlots);
		}
		else
			throw new ParkingSlotNotAvailableException("Parking Slot not available");
	}
	
	@Override
	public void deleteSlot(Long parkingSlotId)   {
		Optional<ParkingSlots> rep = parkingRepository.findById(parkingSlotId);

		if (rep.isEmpty())
			throw new NoSuchParkingSlotException("ParkingSlot Id not found");
		else
			parkingRepository.deleteById(parkingSlotId);
		
	}
	
	@Override
	public boolean checkAvailability(LocalDate parkingDate, String parkingTime) 
	{ 
		
		List<ParkingSlots> slots=parkingRepository.findSlotsforDateandTime(parkingDate, parkingTime);
		
		System.out.println("slots:"+slots);
		
		if(slots.isEmpty())
			return true;
		else
			throw new ParkingSlotNotAvailableException("Parking Slot not available");
			
	}
	
	@Override
	public ParkingSlots getSlotById(long parkingSlotId) {
		Optional<ParkingSlots> optional=	parkingRepository.findById(parkingSlotId);  
		if(!optional.isPresent())		 
			throw new NoSuchParkingSlotException("Parking Slot Details not found for id "+parkingSlotId);	
		return optional.get();    
	}
	
	
	@Override
	public List<ParkingSlots> findAllSlots()
	{
		List<ParkingSlots> slots = parkingRepository.findAll(); 
		return slots;
	}
	
	/*public List<ParkingSlots> findSlotsByPremise(ParkingPremise parkingPremise)
	{
		return parkingRepository.findParkingSlotsByPremise(parkingPremise);
	}*/
	
	
}
