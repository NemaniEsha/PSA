package com.cg.citipark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.citipark.beans.ParkingPremise;

@Repository
public interface ParkingPremiseRepository extends JpaRepository<ParkingPremise, Integer> {

	@Query(value ="SELECT pp FROM ParkingPremise pp WHERE pp.parkingPremiseName=:premiseName")
	List<ParkingPremise> findByParkingPremiseName(@Param("premiseName") String premiseName);
}
