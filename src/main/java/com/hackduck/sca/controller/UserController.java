package com.hackduck.sca.controller;

import com.hackduck.sca.model.Car;
import com.hackduck.sca.model.User;
import com.hackduck.sca.repository.CarRepository;
import com.hackduck.sca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CarRepository carRepository;

    @PostMapping("/users")
    public void insertCustomers() {
        User user=new User();
        user.setFname("1");
        user.setSname("1");
        user.setLname("1");
        user.setStatus(1);
        user.setIduser(UUID.randomUUID());
        user.setPacsid(UUID.randomUUID());
        user.setPacsid(UUID.randomUUID());

        Car car=new Car();
        car.setIdcar(UUID.randomUUID());
        car.setNumber("ADSADSADASD");
        car.setModel("asdsa");
        car.setStatus(1);
        carRepository.save(car);
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        user.setCarList(carList);


        userRepository.save(user);

        System.out.println("SADSADASD");
    }
}
