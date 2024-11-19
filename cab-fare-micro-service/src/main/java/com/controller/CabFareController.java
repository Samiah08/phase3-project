package com.controller;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CabFare;
import com.service.CabFareService;

@RestController
@RequestMapping("cabfare")
public class CabFareController {
	
	@Autowired
	CabFareService cabfareservice;
	
	@PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createCabFare(@RequestBody CabFare cabfare) {
		return cabfareservice.createCabFare(cabfare);
	}
	
	@GetMapping(value = "/findfare/{toLocation}/{fromLocation}/{typeOfCab}")
	public ResponseEntity<Float> findTheCabFare(
	        @PathVariable("toLocation") String toLocation, 
	        @PathVariable("fromLocation") String fromLocation, 
	        @PathVariable("typeOfCab") String typeOfCab) {
	    try {
	        float fare = cabfareservice.findTheCabFare(toLocation, fromLocation, typeOfCab);
	        return ResponseEntity.ok(fare); 
	    } catch (DataAccessException e) {
	       
	        return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
	                .body(null); 
	    } catch (Exception e) {
	      
	        return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
	                .body(null); 
	    }
	}
}
