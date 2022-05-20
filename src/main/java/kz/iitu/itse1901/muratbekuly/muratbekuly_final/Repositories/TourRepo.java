package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface TourRepo {
    List<Tour> findAll();
    Tour findTourById(Long id);
    int saveTour(Tour tour);
    int deleteTour(Long id);
}
