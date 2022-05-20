package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Controller;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.*;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableScheduling
public class AppController {
    @Autowired
    private UserService userService;

    @Autowired
    private TourService tourService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private JmsTemplate jmsTemplate;

    //Get Methods
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/AllUsers")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/AllTours")
    public List<Tour> getAllTours(){
        return tourService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/AllHotels")
    public List<Hotel> getAllHotels(){
        return hotelService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/AllFlights")
    public List<Flight> getAllFlights(){
        return flightService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/AllCreditCards")
    public List<CreditCard> getAllCreditCards(){
        return creditCardService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/AllCountries")
    public List<Country> getAllCountries(){
        return countryService.findAll();
    }

    //Post Methods
    @PostMapping("/saveUser")
    public int addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    //MARK: JMS
    @PostMapping("/SendUserMSG")
    public void send(@RequestBody User user){
        jmsTemplate.convertAndSend("UserQueue",user);
    }
}
