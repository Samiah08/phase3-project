package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CabFare;
import com.repository.CabFareRepository;

@Service
public class CabFareService {
	
	@Autowired 
	CabFareRepository cabfarereporsitory;
	
	public String createCabFare(CabFare cabfare) {
		Optional<CabFare>result = cabfarereporsitory.findById(cabfare.getCf());
		if(result.isPresent()) {
			return "Cab Fare details already exist";
		}else {
			cabfarereporsitory.save(cabfare);
			return "Cab fare record created";
		}
	}
	
    public float findTheCabFare(String toLocation, String fromLocation, String typeOfCab) {
        float fare = cabfarereporsitory.findfare(toLocation, fromLocation, typeOfCab);
        // Check if fare is null and return a default value
        return (fare != 0.0f) ? fare : 0.0f;  // Default fare if null
        }
	
}
