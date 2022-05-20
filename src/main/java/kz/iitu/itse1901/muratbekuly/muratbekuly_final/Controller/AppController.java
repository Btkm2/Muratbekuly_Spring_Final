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
    private JmsTemplate jmsTemplate;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/AllUsers")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    //MARK: JMS
    @PostMapping("/SendUserMSG")
    public void send(@RequestBody User user){
        jmsTemplate.convertAndSend("UserQueue",user);
    }
}
