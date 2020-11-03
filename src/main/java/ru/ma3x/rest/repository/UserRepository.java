package ru.ma3x.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ma3x.rest.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
