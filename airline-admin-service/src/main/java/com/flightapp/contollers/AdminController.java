package com.flightapp.contollers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.client.PassangerController;
import com.flightapp.exception.AdminException;
import com.flightapp.model.BookingSeats;
import com.flightapp.model.FlightDetails;
import com.flightapp.model.SearchDetails;
import com.flightapp.model.SearchResponse;
import com.flightapp.model.StatusUpdate;
import com.flightapp.service.FlightService;

@RestController
@RequestMapping("/flight")
public class AdminController {
	
	
	@Autowired
	private FlightService service;
	
	@PostMapping("/search")
	public Map<String,List<SearchResponse>> searchFlight(@RequestBody SearchDetails details) throws AdminException{
		return service.searchFlightDetails(details);
	}
	
	@PutMapping("/seatbooking")
	public void updateSeat(@RequestBody BookingSeats details){
		service.updateSeat(details);
	}
	
	@PutMapping("/cancelseatbooking")
	public void cancelSeatBooking(@RequestBody BookingSeats details){
		service.cancelSeatBooking(details);
	}
	
	@GetMapping("/view")
	public List<FlightDetails> viewFlight(){
		return service.fetchAllFlights();
	}
	
	@PostMapping("/create")
	public FlightDetails createFlight(@RequestBody FlightDetails details) throws AdminException {
		return service.creatFlight(details);
	}
	
	@PutMapping("/update")
	public String updateFlight(@RequestBody FlightDetails details) throws AdminException{
		return service.updateFlight(details);
	}
	
	@PutMapping("/block")
	public String blockFlight(@RequestBody StatusUpdate details) throws AdminException{
		return service.blockFlight(details);
	}
	
	@PutMapping("/unblock")
	public String unblockFlight(@RequestBody StatusUpdate details) throws AdminException{
		return service.unblockFlight(details);
	}

}