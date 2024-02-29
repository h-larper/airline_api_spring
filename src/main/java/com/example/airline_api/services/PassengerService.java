package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.NewPassengerDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger findPassenger(Long id){
        return passengerRepository.findById(id).get();
    }

    public Passenger savePassenger(NewPassengerDTO newPassengerDTO) {
        Passenger passenger = new Passenger(newPassengerDTO.getName(),newPassengerDTO.getEmail());
        for(Long flightId : newPassengerDTO.getFlightIds()) {
            Flight flight = flightRepository.findById(flightId).get();
            passenger.addFlight(flight);
        }
        return passengerRepository.save(passenger);
    }
}
