package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Services;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Flight;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.FlightRepo;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations.FlightRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService implements FlightRepo {
    private final FlightRepoImpl flightRepoimpl;

    @Autowired
    public FlightService(FlightRepoImpl flightRepoimpl) {
        this.flightRepoimpl = flightRepoimpl;
    }

    @Override
    public List<Flight> findAll() {
        return flightRepoimpl.findAll();
    }

    @Override
    public Flight findFlightById(Long id) {
        return flightRepoimpl.findFlightById(id);
    }

    @Override
    public int saveFlight(Flight flight) {
        return flightRepoimpl.saveFlight(flight);
    }

    @Override
    public int deleteFlight(Long id) {
        return flightRepoimpl.deleteFlight(id);
    }
}
