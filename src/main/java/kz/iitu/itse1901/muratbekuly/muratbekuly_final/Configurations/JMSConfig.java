package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Configurations;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.*;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.Collections;

@Configuration
public class JMSConfig {
    @Bean
    public MappingJackson2MessageConverter messageConverter(){
        val messageConvertor = new MappingJackson2MessageConverter();
        messageConvertor.setTypeIdPropertyName("context-type");
        messageConvertor.setTypeIdMappings(Collections.singletonMap("users", User.class));
        return messageConvertor;
    }
}
