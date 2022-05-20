package kz.iitu.itse1901.muratbekuly.muratbekuly_final.JMS;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.*;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations.UserRepoImpl;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JMSListener {
    @Autowired
    private UserService userService;

    @JmsListener(destination = "UserQueue")
    public void receiveMessage(User user){
        System.out.println("Received <" + user.toString() + ">");
        userService.saveUser(user);
    }
}
