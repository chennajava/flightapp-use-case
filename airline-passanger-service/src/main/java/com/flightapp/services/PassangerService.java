package com.flightapp.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.flightapp.client.AdminClient;
import com.flightapp.exception.PassangerException;
import com.flightapp.model.*;
import com.flightapp.repositories.PassangerRepositories;

@Service
public class PassangerService {

	@Autowired
	private PassangerRepositories repo;

	@Autowired
	private AdminClient admin;
	
	@Autowired
    private KafkaTemplate<String, BookingSeats> kafkaTemplate;
	
	private static final String TOPIC = "kafka-topic";

	public BookingDetails ticketBooking(BookingDetails details) throws PassangerException {
		if (details != null) {
			if (details.getRound_trip() == 0) {
				BookingSeats update = new BookingSeats(details.getFlightId(), 0, false, details.getSeat(),
						details.getTravel_class());
				//admin.updateSeat(update);
				kafkaTemplate.send(TOPIC, update);
			} else {
				BookingSeats update = new BookingSeats(details.getFlightId(),
						details.getRound_trip_details().get(0).getFlight_id(), true, details.getSeat(),
						details.getTravel_class());

				//admin.updateSeat(update);
				kafkaTemplate.send(TOPIC, update);

			}
			LocalDateTime createdate = LocalDateTime.now();
			details.setBooking_date(createdate);
			return repo.save(details);
		}
		throw new PassangerException("Incorrect value recived");

	}

	public BookingDetails searchByPnr(PnrSearch details) throws PassangerException {
		Optional<BookingDetails> optional = repo.findById(details.getPnr());
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new PassangerException("PNR No:- " + details.getPnr() + " is not present");
	}

	public List<BookingDetails> searchByEmailId(EmailIdSearch details) throws PassangerException {
		List<BookingDetails> history = repo.searchByEmailId(details.getEmail_id());
		if (history != null) {
			return history;
		}
		throw new PassangerException("History not present for given email id");
	}

	public String cancelTicket(CancelTicket cancel) throws PassangerException {
		if (cancel != null && cancel.getPnr() != null && cancel.getComment() != null && cancel.getComment() != "") {
			Optional<BookingDetails> optional = repo.findById(cancel.getPnr());
			if (optional.isPresent()) {
				BookingDetails details = optional.get();
				LocalDateTime modifydate = LocalDateTime.now();
				details.setModify_date(modifydate);
				details.setComment(cancel.getComment());
				details.setStatus("cancelled");
				BookingDetails cancel_detail = repo.save(details);

				if (details.getRound_trip() == 0) {

					BookingSeats cancelSeat = new BookingSeats(details.getFlightId(), 0, false, details.getSeat(),
							details.getTravel_class());
					admin.cancelSeatBooking(cancelSeat);
				} else {
					BookingSeats cancelSeat = new BookingSeats(details.getFlightId(),
							details.getRound_trip_details().get(0).getFlight_id(), true, details.getSeat(),
							details.getTravel_class());
					admin.cancelSeatBooking(cancelSeat);

				}
				return "Ticket Id: " + cancel.getPnr() + " is canceled ";
			}
			throw new PassangerException("Ticket id:- " + cancel.getPnr() + " is not present");
		}
		throw new PassangerException("Incorrect value recived");
	}

	public void blockFlight(BlockTicket details) {
		if ((Integer) details.getFlight_id() != null && details.getComment() != null) {
			List<BookingDetails> optional = repo.blockTicket(details.getFlight_id());
			if (optional != null) {
				for (BookingDetails block : optional) {
					if (block.getStatus().equalsIgnoreCase("active")) {
					LocalDateTime modifydate = LocalDateTime.now();
					block.setModify_date(modifydate);
					block.setStatus("block");
					block.setComment(details.getComment());
					BookingDetails flight1 = repo.save(block);
					}
				}
			}
			System.out.print("Not record found");
		}
		System.out.print("Incorrect details");
	}

}