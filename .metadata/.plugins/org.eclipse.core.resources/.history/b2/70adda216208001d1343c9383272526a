package com.dev.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlightDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Integer flight_number;
	private String flight_name;
	private String source;
	private String destination;
	private LocalDateTime departure_time;
	private LocalDateTime arrival_time;
	private Integer bussiness_seat;
	private Integer nonbussiness_seat;
	private double bussiness_fare;
	private double nonbussiness_fare;
	private LocalDateTime created_date;
	private LocalDateTime modify_date;
	private String comment;
	private Integer status;


	 
	
	public FlightDetails(Integer flight_number, String flight_name, String source, String destination,
			LocalDateTime departure_time, LocalDateTime arrival_time, Integer bussiness_seat, Integer nonbussiness_seat,
			double bussiness_fare, double nonbussiness_fare) {
		super();
		this.flight_number = flight_number;
		this.flight_name = flight_name;
		this.source = source;
		this.destination = destination;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.bussiness_seat = bussiness_seat;
		this.nonbussiness_seat = nonbussiness_seat;
		this.bussiness_fare = bussiness_fare;
		this.nonbussiness_fare = nonbussiness_fare;
	}

	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FlightDetails(FlightDetails flightDetails) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FlightDetails(int id, int flight_number, String flight_name, String source, String destination,
			LocalDateTime departure_time, LocalDateTime arrival_time, int bussiness_seat, int nonbussiness_seat,
			double bussiness_fare, double nonbussiness_fare, LocalDateTime created_date, LocalDateTime modify_date,
			String comment, int status) {
		super();
		this.id = id;
		this.flight_number = flight_number;
		this.flight_name = flight_name;
		this.source = source;
		this.destination = destination;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.bussiness_seat = bussiness_seat;
		this.nonbussiness_seat = nonbussiness_seat;
		this.bussiness_fare = bussiness_fare;
		this.nonbussiness_fare = nonbussiness_fare;
		this.created_date = created_date;
		this.modify_date = modify_date;
		this.comment = comment;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlight_number() {
		return flight_number;
	}
	
	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}
	public String getFlight_name() {
		return flight_name;
	}
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDateTime getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(LocalDateTime departure_time) {
		this.departure_time = departure_time;
	}
	public LocalDateTime getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(LocalDateTime arrival_time) {
		this.arrival_time = arrival_time;
	}
	public int getBussiness_seat() {
		return bussiness_seat;
	}
	public void setBussiness_seat(int bussiness_seat) {
		this.bussiness_seat = bussiness_seat;
	}
	public int getNonbussiness_seat() {
		return nonbussiness_seat;
	}
	public void setNonbussiness_seat(int nonbussiness_seat) {
		this.nonbussiness_seat = nonbussiness_seat;
	}
	public double getBussiness_fare() {
		return bussiness_fare;
	}
	public void setBussiness_fare(double bussiness_fare) {
		this.bussiness_fare = bussiness_fare;
	}
	public double getNonbussiness_fare() {
		return nonbussiness_fare;
	}
	public void setNonbussiness_fare(double nonbussiness_fare) {
		this.nonbussiness_fare = nonbussiness_fare;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public LocalDateTime getModify_date() {
		return modify_date;
	}
	public void setModify_date(LocalDateTime modify_date) {
		this.modify_date = modify_date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
