package com.dev.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.dev.client.PassangerController;
import com.dev.exception.AdminException;
import com.dev.model.*;
import com.dev.repositories.FlightRepositories;

@Service
public class FlightService {

	@Autowired
	private PassangerController passanger;
	
	private static final String TOPIC = "kafka-topic";

	@Autowired
	private FlightRepositories repo;

	public Map<String, List<SearchResponse>> searchFlightDetails(SearchDetails details) throws AdminException {

		if (!details.isReturn_trip()) {

			if (details.getSource() != null && details.getDestination() != null && details.getJourney_date() != null
					&& details.getSeat() != null && details.getClass_type() != null && details.getSeat() != 0) {
				Map<String, List<SearchResponse>> map = new HashMap<>();
				if (details.getClass_type().equalsIgnoreCase("bussiness")) {

					List<SearchResponse> response = repo.searchBusFlight(details.getSource(), details.getDestination(),
							details.getJourney_date(), details.getSeat());
					map.put("OneWay", response);
					return map;

				} else if (details.getClass_type().equalsIgnoreCase("nonbussiness")) {

					List<SearchResponse> response = repo.searchNonBusFlight(details.getSource(),
							details.getDestination(), details.getJourney_date(), details.getSeat());
					map.put("OneWay", response);
					return map;
				}
				throw new AdminException("Incorrect value recived");

			}
			throw new AdminException("Incorrect value recived");
		} else {
			if (details.getSource() != null && details.getDestination() != null && details.getJourney_date() != null
					&& details.getSeat() != null && details.getClass_type() != null && details.getSeat() != 0
					&& details.getReturn_destination() != null && details.getReturn_source() != null
					&& details.getReturn_date() != null) {
				Map<String, List<SearchResponse>> map = new HashMap<>();
				if (details.getClass_type().equalsIgnoreCase("bussiness")) {

					List<SearchResponse> response = repo.searchBusFlight(details.getSource(), details.getDestination(),
							details.getJourney_date(), details.getSeat());
					map.put("OneWay", response);
					List<SearchResponse> response1 = repo.searchBusReFlight(details.getReturn_source(),
							details.getReturn_destination(), details.getReturn_date(), details.getSeat());
					map.put("TwoWay", response1);
					return map;
				} else if (details.getClass_type().equalsIgnoreCase("nonbussiness")) {

					List<SearchResponse> response = repo.searchNonBusFlight(details.getSource(),
							details.getDestination(), details.getJourney_date(), details.getSeat());
					map.put("OneWay", response);
					List<SearchResponse> response1 = repo.searchNonBusReFlight(details.getReturn_source(),
							details.getReturn_destination(), details.getReturn_date(), details.getSeat());
					map.put("TwoWay", response1);
					return map;
				}
				throw new AdminException("Incorrect value recived");

			}
			throw new AdminException("Incorrect value recived");
		}

	}

	public List<FlightDetails> fetchAllFlights() {
		System.out.println("find all flights");
		return repo.findAll();
	}

	public FlightDetails creatFlight(FlightDetails details) throws AdminException {
		if (details != null) {
			LocalDateTime createdate = LocalDateTime.now();
			details.setCreated_date(createdate);
			details.setStatus(1);
			return repo.save(details);
		}
		throw new AdminException("Incorrect value recived");
	}
	
	@KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
	public void updateSeat(BookingSeats details) {
		Optional<FlightDetails> optional = repo.findById(details.getFlight_id());
		if (optional.isPresent()) {
			FlightDetails flight = optional.get();
			if (details.getTravel_class().equalsIgnoreCase("bussiness")) {
				int avail_seat = optional.get().getBussiness_seat();
				int req_seat = details.getSeat();
				avail_seat = avail_seat - req_seat;
				flight.setBussiness_seat(avail_seat);

				FlightDetails flight1 = repo.save(flight);
			} else if (details.getTravel_class().equalsIgnoreCase("nonbussiness")) {

				int avail_seat = optional.get().getNonbussiness_seat();
				int req_seat = details.getSeat();
				avail_seat = avail_seat - req_seat;
				flight.setNonbussiness_seat(avail_seat);

				FlightDetails flight1 = repo.save(flight);
			}
		}
		if (details.isReturn_trip()) {
			Optional<FlightDetails> reoptional = repo.findById(details.getReturn_flight_id());
			if (reoptional.isPresent()) {
				FlightDetails flight = reoptional.get();
				if (details.getTravel_class().equalsIgnoreCase("bussiness")) {
					int avail_seat = reoptional.get().getBussiness_seat();
					int req_seat = details.getSeat();
					avail_seat = avail_seat - req_seat;
					flight.setBussiness_seat(avail_seat);

					FlightDetails flight1 = repo.save(flight);
				} else if (details.getTravel_class().equalsIgnoreCase("nonbussiness")) {

					int avail_seat = reoptional.get().getNonbussiness_seat();
					int req_seat = details.getSeat();
					avail_seat = avail_seat - req_seat;
					flight.setNonbussiness_seat(avail_seat);

					FlightDetails flight1 = repo.save(flight);
				}
			}
		}

	}

	public void cancelSeatBooking(BookingSeats details) {
		Optional<FlightDetails> optional = repo.findById(details.getFlight_id());
		if (optional.isPresent()) {
			FlightDetails flight = optional.get();
			if (details.getTravel_class().equalsIgnoreCase("bussiness")) {
				int avail_seat = optional.get().getBussiness_seat();
				int req_seat = details.getSeat();
				avail_seat = avail_seat + req_seat;
				flight.setBussiness_seat(avail_seat);

				FlightDetails flight1 = repo.save(flight);
			} else if (details.getTravel_class().equalsIgnoreCase("nonbussiness")) {

				int avail_seat = optional.get().getNonbussiness_seat();
				int req_seat = details.getSeat();
				avail_seat = avail_seat + req_seat;
				flight.setNonbussiness_seat(avail_seat);

				FlightDetails flight1 = repo.save(flight);
			}
		}
		if (details.isReturn_trip()) {
			Optional<FlightDetails> reoptional = repo.findById(details.getReturn_flight_id());
			if (reoptional.isPresent()) {
				FlightDetails flight = reoptional.get();
				if (details.getTravel_class().equalsIgnoreCase("bussiness")) {
					int avail_seat = reoptional.get().getBussiness_seat();
					int req_seat = details.getSeat();
					avail_seat = avail_seat + req_seat;
					flight.setBussiness_seat(avail_seat);

					FlightDetails flight1 = repo.save(flight);
				} else if (details.getTravel_class().equalsIgnoreCase("nonbussiness")) {

					int avail_seat = reoptional.get().getNonbussiness_seat();
					int req_seat = details.getSeat();
					avail_seat = avail_seat + req_seat;
					flight.setNonbussiness_seat(avail_seat);

					FlightDetails flight1 = repo.save(flight);
				}
			}
		}

	}

	public String updateFlight(FlightDetails details) throws AdminException {
		if (details != null && (Integer) details.getId() != null) {
			Optional<FlightDetails> optional = repo.findById(details.getId());
			if (optional.isPresent()) {
				LocalDateTime modifydate = LocalDateTime.now();
				details.setModify_date(modifydate);
				details.setCreated_date(optional.get().getCreated_date());
				FlightDetails flight = repo.save(details);
				return "Flight id:- " + details.getId() + " details is updated";
			} else {
				throw new AdminException("Flight id:- " + details.getId() + " is not present");

			}
		}
		throw new AdminException("Incorrect value recived");
	}

	public String blockFlight(StatusUpdate details) throws AdminException {
		if ((Integer) details.getFlight_id() != null && details.getComment() != null) {
			Optional<FlightDetails> optional = repo.findById(details.getFlight_id());
			if (optional.isPresent()) {
				FlightDetails flight = optional.get();
				LocalDateTime modifydate = LocalDateTime.now();
				flight.setModify_date(modifydate);
				flight.setStatus(0);
				flight.setComment(details.getComment());
				FlightDetails flight1 = repo.save(flight);
				details.setComment("Flight is cancelled.Sorry for the inconvince");
				passanger.blockticket(details);
				return "Flight id:- " + details.getFlight_id() + " is blocked";
			} else {
				throw new AdminException("Flight id:- " + details.getFlight_id() + " is not present");
			}
		}
		throw new AdminException("Incorrect value recived");
	}

	public String unblockFlight(StatusUpdate details) throws AdminException {
		if ((Integer) details.getFlight_id() != null && details.getComment() != null) {
			Optional<FlightDetails> optional = repo.findById(details.getFlight_id());
			if (optional.isPresent()) {
				FlightDetails flight = optional.get();
				LocalDateTime modifydate = LocalDateTime.now();
				flight.setModify_date(modifydate);
				flight.setStatus(1);
				flight.setComment(details.getComment());
				FlightDetails flight1 = repo.save(flight);
				return "Flight id:- " + details.getFlight_id() + " is unblocked";
			} else {
				throw new AdminException("Flight id:- " + details.getFlight_id() + " is not present");
			}
		}
		throw new AdminException("Incorrect value recived");
	}

}
