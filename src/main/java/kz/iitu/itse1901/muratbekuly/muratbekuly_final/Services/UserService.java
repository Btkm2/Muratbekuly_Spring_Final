package kz.iitu.itse1901.muratbekuly.muratbekuly_final.Services;

import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Models.User;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.Implementations.UserRepoImpl;
import kz.iitu.itse1901.muratbekuly.muratbekuly_final.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserRepo {
    private final UserRepoImpl userRepoimpl;

    public UserService(UserRepoImpl userRepoimpl) {
        this.userRepoimpl = userRepoimpl;
    }

    @Override
    public List<User> findAll() {
        return userRepoimpl.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepoimpl.findUserById(id);
    }

    @Override
    public int saveUser(User user) {
        return userRepoimpl.saveUser(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userRepoimpl.deleteUser(id);
    }
}
