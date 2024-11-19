package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.entity.Booking;
import com.model.BookingResponse;
import com.service.BookingService;



@Controller
@RequestMapping("/cab")
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String openFirstPage() {
		System.out.println("opening index page");
		return "index";
	}

	@GetMapping("/book")
    public String showBookingForm(Model model) {
        model.addAttribute("booking", new Booking()); 
        return "bookCab"; 
    }

    @PostMapping("/bookingcab")
    public String bookTheCabFromForm(@ModelAttribute Booking booking, Model model) {
        BookingResponse response = bookingService.bookTheCab(booking);
        model.addAttribute("response", response);
        return "confirmation"; 
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BookingResponse bookTheCab(@RequestBody Booking booking) {
        return bookingService.bookTheCab(booking); 
    }
    
	
	@GetMapping("/fare")
    public String showcabfareForm(Model model) {
        model.addAttribute("booking", new Booking()); 
        return "cabfare"; 
    }

    @PostMapping("/calculatefare")
    public String cabfarecalculateForm(@ModelAttribute Booking booking, Model model) {
        BookingResponse response = bookingService.findcabfare(booking);
        model.addAttribute("response", response);
        return "calculatecab"; 
    }

    @PostMapping(value = "/find", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BookingResponse findcabfare(@RequestBody Booking booking) {
        return bookingService.findcabfare(booking); 
    }
	
}
	
