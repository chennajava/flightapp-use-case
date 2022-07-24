package com.dev.contollers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.client.PassangerController;
import com.dev.exception.AdminException;
import com.dev.model.BookingSeats;
import com.dev.model.FlightDetails;
import com.dev.model.SearchDetails;
import com.dev.model.SearchResponse;
import com.dev.model.StatusUpdate;
import com.dev.services.FlightService;

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
