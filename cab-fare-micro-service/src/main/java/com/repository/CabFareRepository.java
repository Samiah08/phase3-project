package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.CabFare;

@Repository
public interface CabFareRepository extends JpaRepository<CabFare, Integer>{
	
	@Query("select cf.amount from CabFare cf where cf.tolocation=:tolocation and cf.fromlocation=:fromlocation and cf.typeofcab=:typeofcab")
	public float findfare(@Param("tolocation") String toLocation, 
            			  @Param("fromlocation") String fromLocation, 
            			  @Param("typeofcab") String typeOfCab);
}

