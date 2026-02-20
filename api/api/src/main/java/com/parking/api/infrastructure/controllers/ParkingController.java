package com.parking.api.infrastructure.controllers;

import com.parking.api.application.services.ParkingService;
import com.parking.api.domain.models.Parking;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/parqueadero")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Operation(summary = "Listar todos los usuarios")
    @GetMapping
    public ResponseEntity<Flux<Parking>> findAll() {
        return ResponseEntity.ok(parkingService.getParkings());
    }
    @PostMapping
    public ResponseEntity<Mono<Parking>> save(@RequestBody Parking parking) {
        return ResponseEntity.ok(parkingService.save(parking));
    }
}
