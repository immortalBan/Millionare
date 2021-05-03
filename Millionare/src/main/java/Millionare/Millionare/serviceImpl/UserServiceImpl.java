package Millionare.Millionare.serviceImpl;

import Millionare.Millionare.entity.User;
import Millionare.Millionare.repo.UserRepo;
import Millionare.Millionare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> readAll() {
        return userRepo.findAll();
    }

    @Override
    public User read(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public boolean update(User user, Long id) {
        if (read(id) != null){
            User newUser = new User();
            newUser.setId(id);
            newUser.setLogin(user.getLogin());
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setBirthday(user.getBirthday());
            newUser.setTimeCreated(user.getTimeCreated());

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        if (read(id) != null) {
            userRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
