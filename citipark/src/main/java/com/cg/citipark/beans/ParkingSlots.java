package com.cg.citipark.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ParkingSlots {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long parkingSlotId;
	@OneToOne(targetEntity=Vehicle.class)
	private Vehicle vehicle;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate parkingDate;
	@NotBlank(message = "Enter Parking Time")
	private String parkingTime;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingDate;
	@NotBlank(message = "Enter Parking Time")
	private int parkingDuration;
	@ManyToOne(targetEntity = ParkingPremise.class, cascade = CascadeType.MERGE)
	private ParkingPremise parkingPremise;
	
	public ParkingPremise getParkingPremise() {
		return parkingPremise;
	}
	public void setParkingPremise(ParkingPremise parkingPremise) {
		this.parkingPremise = parkingPremise;
	}
	public LocalDate getParkingDate() {
		return parkingDate;
	}
	public void setParkingDate(LocalDate parkingDate) {
		this.parkingDate = parkingDate;
	}
	public String getParkingTime() {
		return parkingTime;
	}
	public void setParkingTime(String parkingTime) {
		this.parkingTime = parkingTime;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getParkingDuration() {
		return parkingDuration;
	}
	public void setParkingDuration(int parkingDuration) {
		this.parkingDuration = parkingDuration;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	@PrePersist
	public void onCreate()
	{
		this.bookingDate=LocalDate.now();
		
	}
	@Override
	public String toString() {
		return "ParkingSlots [parkingSlotId=" + parkingSlotId + ", vehicle=" + vehicle + ", parkingDate=" + parkingDate
				+ ", parkingTime=" + parkingTime + ", bookingDate=" + bookingDate + ", parkingDuration="
				+ parkingDuration + ", parkingPremise=" + parkingPremise + "]";
	}
	
	
	
	
	
	
}
