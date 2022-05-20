package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Flight;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepo {
    List<Flight> findAll();
    Flight findFlightById(Long id);
    Flight saveFlight(Flight flight);
    void deleteFlight(Flight flight);
}
