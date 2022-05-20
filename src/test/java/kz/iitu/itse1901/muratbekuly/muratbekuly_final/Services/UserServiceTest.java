package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Services;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.*;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations.UserRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    UserRepoImpl userRepoimpl;
    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        when(userRepoimpl.findAll()).thenReturn(List.of(new User(Long.valueOf(1), "name", "lastname", "email", "phone_number", new Tour(Long.valueOf(1), new Country(Long.valueOf(1), "name", "capital"), "duration", new Flight(Long.valueOf(1), Integer.valueOf(0), new Country(Long.valueOf(1), "name", "capital")), new Hotel(Long.valueOf(1), "hotel_name", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)), Integer.valueOf(0)), new CreditCard(Long.valueOf(1), "currency", Integer.valueOf(0)))));

        List<User> result = userService.findAll();
        Assertions.assertEquals(List.of(new User(Long.valueOf(1), "name", "lastname", "email", "phone_number", new Tour(Long.valueOf(1), new Country(Long.valueOf(1), "name", "capital"), "duration", new Flight(Long.valueOf(1), Integer.valueOf(0), new Country(Long.valueOf(1), "name", "capital")), new Hotel(Long.valueOf(1), "hotel_name", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)), Integer.valueOf(0)), new CreditCard(Long.valueOf(1), "currency", Integer.valueOf(0)))), result);
    }

    @Test
    void testFindUserById() {
        when(userRepoimpl.findUserById(anyLong())).thenReturn(new User(Long.valueOf(1), "name", "lastname", "email", "phone_number", new Tour(Long.valueOf(1), new Country(Long.valueOf(1), "name", "capital"), "duration", new Flight(Long.valueOf(1), Integer.valueOf(0), new Country(Long.valueOf(1), "name", "capital")), new Hotel(Long.valueOf(1), "hotel_name", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)), Integer.valueOf(0)), new CreditCard(Long.valueOf(1), "currency", Integer.valueOf(0))));

        User result = userService.findUserById(Long.valueOf(1));
        Assertions.assertEquals(new User(Long.valueOf(1), "name", "lastname", "email", "phone_number", new Tour(Long.valueOf(1), new Country(Long.valueOf(1), "name", "capital"), "duration", new Flight(Long.valueOf(1), Integer.valueOf(0), new Country(Long.valueOf(1), "name", "capital")), new Hotel(Long.valueOf(1), "hotel_name", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)), Integer.valueOf(0)), new CreditCard(Long.valueOf(1), "currency", Integer.valueOf(0))), result);
    }

    @Test
    void testSaveUser() {
        when(userRepoimpl.saveUser(any())).thenReturn(0);

        int result = userService.saveUser(new User(Long.valueOf(1), "name", "lastname", "email", "phone_number", new Tour(Long.valueOf(1), new Country(Long.valueOf(1), "name", "capital"), "duration", new Flight(Long.valueOf(1), Integer.valueOf(0), new Country(Long.valueOf(1), "name", "capital")), new Hotel(Long.valueOf(1), "hotel_name", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)), Integer.valueOf(0)), new CreditCard(Long.valueOf(1), "currency", Integer.valueOf(0))));
        Assertions.assertEquals(0, result);
    }

    @Test
    void testDeleteUser() {
        when(userRepoimpl.deleteUser(anyLong())).thenReturn(0);

        int result = userService.deleteUser(Long.valueOf(1));
        Assertions.assertEquals(0, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme