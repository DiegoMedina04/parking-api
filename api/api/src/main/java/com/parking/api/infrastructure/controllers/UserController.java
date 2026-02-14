package com.parking.api.infrastructure.controllers;

import com.parking.api.application.services.UserService;
import com.parking.api.domain.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/saludar")
    public ResponseEntity<String> saludar() {
        return ResponseEntity.ok("Hola 22");
    }


    @GetMapping
    public ResponseEntity<Flux<User>> findAll() {
        return ResponseEntity.ok(userService.getUsers());
    }
    @PostMapping
    public ResponseEntity<Mono<User>> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
