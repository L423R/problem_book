package ru.ma3x.rest.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.ma3x.rest.model.User;
import ru.ma3x.rest.services.UserService;

import static java.nio.charset.StandardCharsets.UTF_8;

@Controller
public class SecurityController {
    UserService service;

    public SecurityController(UserService service) {
        this.service = service;
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<User> check(@RequestHeader("Authorization") String authorization) {
        String base64String = authorization.split(" ")[1];
        byte[] bytes = Base64.decodeBase64(base64String);
        String s = new String(bytes, UTF_8).split(":")[0];
        User user = service.get(s);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
