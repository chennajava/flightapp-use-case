package com.flightapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.models.JwtRequest;


public interface JwtRepositorie extends JpaRepository<JwtRequest, String>  {

}
