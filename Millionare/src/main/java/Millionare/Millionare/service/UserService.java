package Millionare.Millionare.service;

import Millionare.Millionare.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User create(User user);

    List<User> readAll();

    User read(Long id);

    boolean update(User user, Long id);

    boolean delete(Long id);
}
