package com.parking.api.infrastructure.controllers;

import com.parking.api.application.services.RoleService;
import com.parking.api.application.services.UserService;
import com.parking.api.domain.models.Role;
import com.parking.api.domain.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rol")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }



    @GetMapping
    public ResponseEntity<Flux<Role>> findAll() {
        return ResponseEntity.ok(roleService.getRoles());
    }
    @PostMapping
    public ResponseEntity<Mono<Role>> save(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.save(role));
    }
}
