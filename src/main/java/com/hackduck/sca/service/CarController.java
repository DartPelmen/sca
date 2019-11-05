package com.hackduck.sca.service;

import com.hackduck.sca.model.Car;
import com.hackduck.sca.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CarController {
    @Autowired
    CarRepository carRepository;
    @PostMapping("/cars")
    public void insertCustomers() {
        Car user=new Car();
        user.setIdcar(UUID.randomUUID());
        user.setNumber("ADSADSADASD");
        user.setModel("asdsa");
        user.setStatus(1);

        user.setPacsid(UUID.randomUUID());
        carRepository.save(user);
        System.out.println("SADSADASD");
    }
}
