package com.parking.api.infrastructure.config;

import com.parking.api.application.services.ParkingService;
import com.parking.api.application.usesCases.parking.CreateParkingUseCaseImpl;
import com.parking.api.application.usesCases.parking.RetrieveParkingUseCaseImpl;
import com.parking.api.domain.ports.in.parking.CreateParkinUseCase;
import com.parking.api.domain.ports.in.parking.RetrieveParkingUseCase;
import com.parking.api.domain.ports.out.ParkingRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParkingConfig {

    @Bean
    public RetrieveParkingUseCase retrieveParkingUseCase(ParkingRepositoryPort parkingRepositoryPort) {
        return new RetrieveParkingUseCaseImpl(parkingRepositoryPort);
    }

   @Bean
    public CreateParkinUseCase createParkinUseCase(ParkingRepositoryPort parkingRepositoryPort) {
        return new CreateParkingUseCaseImpl(parkingRepositoryPort);
    }

   @Bean
    public ParkingService parkingService(
           RetrieveParkingUseCase retrieveParkingUseCase,
           CreateParkinUseCase createParkinUseCase
   ) {
        return new ParkingService(retrieveParkingUseCase, createParkinUseCase);
   }
}
