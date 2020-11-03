package ru.ma3x.rest.services;

import org.springframework.stereotype.Service;
import ru.ma3x.rest.model.User;
import ru.ma3x.rest.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User get(String email) {
        Optional<User> optionalUser = repository.findByEmail(email);
        return optionalUser.orElse(null);
    }

}
