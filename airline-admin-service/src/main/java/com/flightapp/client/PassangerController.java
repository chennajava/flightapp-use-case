package com.flightapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.flightapp.model.StatusUpdate;

@FeignClient("passanger")
public interface PassangerController {
	
	@PutMapping("/airtravel/blockticket")
	public void blockticket(@RequestBody StatusUpdate details);
	

}
