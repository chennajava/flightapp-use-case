package com.flightapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.client.AdminClient;
import com.flightapp.exception.PassangerException;
import com.flightapp.model.*;
import com.flightapp.services.PassangerService;

@RestController
@RequestMapping("/airtravel")
public class PassangerController {

	@Autowired
	private PassangerService service;
	
	@Autowired
	private AdminClient admin;

	@PostMapping("/service/booking")
	private BookingDetails ticketBooking(@RequestBody BookingDetails detail) throws PassangerException {
		return service.ticketBooking(detail);
	}
	
	@GetMapping("/service/searchbypnr")
	private BookingDetails searchByPnr(@RequestBody  PnrSearch search) throws PassangerException {
		return service.searchByPnr(search);
	}
	
	@GetMapping("/service/searchbyemailid")
	private List<BookingDetails> searchByEmailId(@RequestBody EmailIdSearch search) throws PassangerException {
		return service.searchByEmailId(search);
	}
	
	@PutMapping("/service/cancel")
	private String cancelTicket(@RequestBody CancelTicket cancel) throws PassangerException {
		return service.cancelTicket(cancel);
	}
	
	@PostMapping("/service/search")
	Map<String,List<SearchResponse>> getflight(@RequestBody SearchDetails details){
		return admin.getflight(details);
	}
	
	@PutMapping("/blockticket")
	public void blockticket(@RequestBody BlockTicket details){
		service.blockFlight(details);
	}
	
}
