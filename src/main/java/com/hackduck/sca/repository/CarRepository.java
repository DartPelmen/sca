package com.hackduck.sca.repository;

import com.hackduck.sca.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    Car findByIdcar(UUID idcar);
}
