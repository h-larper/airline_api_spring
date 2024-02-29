package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Flight fabFlight = new Flight("Miami", 2, "Tomorrow", "12:10");
        flightRepository.save(fabFlight);

        Flight speedyFlight = new Flight("Bali", 5, "05/04/24", "13:10");
        flightRepository.save(fabFlight);

        Passenger colin = new Passenger("Colin", "Colin@Colin.com");
        colin.addFlight(speedyFlight);
        passengerRepository.save(zsolt);

        Passenger zsolt = new Passenger("Zsolt", "Zsolt@Zsolt.com");
        zsolt.addFlight(fabFlight);
        passengerRepository.save(zsolt);

        Passenger anna = new Passenger("Anna", "Anna@Anna.com");
        anna.addFlight(speedyFlight);
        passengerRepository.save(zsolt);

        Passenger paneer = new Passenger("Paneer", "Paneer@doggyemails.com");
        panneer.addFlight(fabFlight);
        passengerRepository.save(paneer);
    }

}