package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo {
    List<User> findAll();
    User findUserById(Long id);
    int saveUser(User user);
    int deleteUser(Long id);
}
