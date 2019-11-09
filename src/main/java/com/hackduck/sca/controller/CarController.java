package com.hackduck.sca.controller;

import com.hackduck.sca.model.Car;
import com.hackduck.sca.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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
    @GetMapping("/cars/pages/{pageno}")
    @ResponseBody
    public List<Car> getAllCars(@PathVariable("pageno") int pageno, HttpServletRequest req, HttpServletResponse res) throws ServletException {
        return carRepository.findAll(PageRequest.of(pageno,10,Sort.by("model"))).toList();
    }
}

