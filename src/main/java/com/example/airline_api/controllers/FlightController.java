package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightService;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        return new ResponseEntity<>(flightService.findFlightById(id), HttpStatus.OK);
    }


    // Add details of a new flight

@PostMapping
public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
    flightService.addNewFlight(flight);
    return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    // Book a passenger on a flight
    @Transactional
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(@RequestBody FlightDTO flightDTO, @PathVariable long id){
        Flight flight = flightService.bookPassenger(flightDTO, id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> cancelFlight(@PathVariable Long id){
        flightService.cancelFlight(id);
        return new ResponseEntity<String>("That flight has been cancelled :(", HttpStatus.OK);
    }

}
