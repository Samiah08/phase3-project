package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.entity.Booking;
import com.model.BookingResponse;
import com.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingrepository;
	
	
	@Autowired
	RestTemplate resttemplate;
	
	public BookingResponse bookTheCab(Booking booking) {
        String emailid = booking.getEmailid();
        String toLocation = booking.getTolocation();
        String fromLocation = booking.getFromlocation();
        String typeOfCab = booking.getTypeofcab();

        try {
          
            Float fare = resttemplate.getForObject(
                    "http://localhost:8282/cabfare/findfare/" + toLocation + "/" + fromLocation + "/" + typeOfCab, 
                    Float.class);

            
            if (fare != null && fare > 0) {
                booking.setAmount(fare);
                bookingrepository.save(booking);
                return new BookingResponse(fare, "Booking was successful from "+fromLocation+" to "+toLocation);
            } else {
                
                return new BookingResponse(0, "Cab fare not available");
            }
        } catch (Exception e) {
          
            e.printStackTrace();
            return new BookingResponse(0, "Could not book canb. Error occurred while fetching the cab fare");
        }
    }
	
	 

	
	public BookingResponse findcabfare(Booking booking) {
        String toLocation = booking.getTolocation();
        String fromLocation = booking.getFromlocation();
        String typeOfCab = booking.getTypeofcab();

        try {
           
            Float fare = resttemplate.getForObject(
                    "http://localhost:8282/cabfare/findfare/" + toLocation + "/" + fromLocation + "/" + typeOfCab, 
                    Float.class);

          
            if (fare != null && fare > 0) {
                booking.setAmount(fare);
                return new BookingResponse(fare,"The cab fare is : £"+fare);
            } else {
                
                return new BookingResponse(0, "Cab fare not available");
            }
        } catch (Exception e) {
            
            e.printStackTrace();
            return new BookingResponse(0, "Error occurred while fetching the cab fare");
        }
    }

}
