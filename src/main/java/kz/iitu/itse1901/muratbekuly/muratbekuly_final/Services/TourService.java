package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Services;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.Tour;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations.TourRepoImpl;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.TourRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
public class TourService implements TourRepo {
    private final TourRepoImpl tourRepoimpl;

    @Autowired
    public TourService(TourRepoImpl tourRepoimpl) {
        this.tourRepoimpl = tourRepoimpl;
    }

    @Override
    @Scheduled(fixedDelay = 10,initialDelay = 2000)
    public List<Tour> findAll() {
        return tourRepoimpl.findAll();
    }

    @Override
    public Tour findTourById(Long id) {
        return tourRepoimpl.findTourById(id);
    }

    @Override
    public int saveTour(Tour tour) {
        return tourRepoimpl.saveTour(tour);
    }

    @Override
    public int deleteTour(Long id) {
        return tourRepoimpl.deleteTour(id);
    }
}
