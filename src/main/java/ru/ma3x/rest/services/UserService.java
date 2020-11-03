package ru.ma3x.rest.services;

import ru.ma3x.rest.model.User;

public interface UserService extends BaseService<User> {
    User get(String email);
}
