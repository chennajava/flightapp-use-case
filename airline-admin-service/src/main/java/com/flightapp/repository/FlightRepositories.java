package com.flightapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightapp.model.FlightDetails;
import com.flightapp.model.SearchResponse;

public interface FlightRepositories extends JpaRepository<FlightDetails,Integer>{
	
	@Query("SELECT new com.flightapp.model.SearchResponse(a.id,a.flight_number,a.flight_name,a.source,a.destination,a.departure_time,a.arrival_time,a.bussiness_fare) FROM FlightDetails a WHERE a.source = ?1 AND a.destination = ?2 AND CAST(a.departure_time AS LocalDate) = ?3 and a.bussiness_seat >= ?4 and a.status=1")
    List<SearchResponse> searchBusFlight(String source,String destination,LocalDate journey_date,Integer seat);
	
	@Query("SELECT new com.flightapp.model.SearchResponse(a.id,a.flight_number,a.flight_name,a.source,a.destination,a.departure_time,a.arrival_time,a.nonbussiness_fare) FROM FlightDetails a WHERE a.source = ?1 AND a.destination = ?2 AND CAST(a.departure_time AS LocalDate) = ?3 and a.nonbussiness_seat >= ?4 and a.status=1")
    List<SearchResponse> searchNonBusFlight(String source,String destination,LocalDate journey_date,Integer seat);
	
	@Query("SELECT new com.flightapp.model.SearchResponse(a.id,a.flight_number,a.flight_name,a.source,a.destination,a.departure_time,a.arrival_time,a.bussiness_fare) FROM FlightDetails a WHERE a.source = ?1 AND a.destination = ?2 AND CAST(a.departure_time AS LocalDate) = ?3 and a.bussiness_seat >= ?4 and a.status=1")
    List<SearchResponse> searchBusReFlight(String source,String destination,LocalDate journey_date,Integer seat);
	
	@Query("SELECT new com.flightapp.model.SearchResponse(a.id,a.flight_number,a.flight_name,a.source,a.destination,a.departure_time,a.arrival_time,a.nonbussiness_fare) FROM FlightDetails a WHERE a.source = ?1 AND a.destination = ?2 AND CAST(a.departure_time AS LocalDate) = ?3 and a.nonbussiness_seat >= ?4 and a.status=1")
    List<SearchResponse> searchNonBusReFlight(String source,String destination,LocalDate journey_date,Integer seat);

}
