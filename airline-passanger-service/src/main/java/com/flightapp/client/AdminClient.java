package com.flightapp.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.flightapp.model.BookingSeats;
import com.flightapp.model.SearchDetails;
import com.flightapp.model.SearchResponse;

@FeignClient("admin")
public interface AdminClient {

	@PostMapping("/flight/search")
	Map<String,List<SearchResponse>> getflight(@RequestBody SearchDetails details);
	
	@PutMapping("/flight/seatbooking")
	void updateSeat(@RequestBody BookingSeats details);
	
	@PutMapping("/flight/cancelseatbooking")
	void cancelSeatBooking(@RequestBody BookingSeats details);
	
}
