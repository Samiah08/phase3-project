package com.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import com.entity.Booking;
import com.model.BookingResponse;
import com.repository.BookingRepository;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

	    @Mock
	    private RestTemplate restTemplate;

	    @Mock
	    private BookingRepository bookingrepository;

	    @InjectMocks
	    private BookingService bookingservice;

	    private Booking booking;

	    @BeforeEach
	    void setUp() {
	        booking = new Booking();
	        booking.setEmailid("test@example.com");
	        booking.setFromlocation("birmingham");
	        booking.setTolocation("london");
	        booking.setTypeofcab("bmw");
	    }

	@Test
	
	void testBookTheCab_SuccessfulBooking() {
		
	        // Mock the cab fare
	        Float mockFare = 500.0f;
	        when(restTemplate.getForObject("http://localhost:8282/cabfare/findfare/london/birmingham/bmw", Float.class))
	                .thenReturn(mockFare);

	        // Mock repository save
	        when(bookingrepository.save(any(Booking.class))).thenReturn(booking);

	        // Call the method
	        BookingResponse response = bookingservice.bookTheCab(booking);

	        // Verify and assert
	        verify(restTemplate, times(1))
	                .getForObject("http://localhost:8282/cabfare/findfare/london/birmingham/bmw", Float.class);
	        verify(bookingrepository, times(1)).save(any(Booking.class));

	        assertEquals(mockFare, response.getFare());
	        assertEquals("Booking was successful from birmingham to london", response.getMessage());
	    }
	

    @Test
    
    void testFindcabfare_Successful() {
        // Mock the cab fare
        Float mockFare = 500.0f;
        when(restTemplate.getForObject("http://localhost:8282/cabfare/findfare/london/birmingham/bmw", Float.class))
                .thenReturn(mockFare);

        // Call the method
        BookingResponse response = bookingservice.findcabfare(booking);

        // Verify and assert
        verify(restTemplate, times(1))
                .getForObject("http://localhost:8282/cabfare/findfare/london/birmingham/bmw", Float.class);

        assertEquals(mockFare, response.getFare());
        assertEquals("The cab fare is : £500.0", response.getMessage());
    }

}