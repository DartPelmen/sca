package com.hackduck.sca.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackduck.sca.model.Car;
import com.hackduck.sca.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

@RestController
public class CarController {
    @Autowired
    CarRepository carRepository;
    @PostMapping("/cars")
    @ResponseBody
    public void insertCar(@RequestBody String postedCar) throws JsonProcessingException {
        Car car= new Car();
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(postedCar);
        car.setIdcar(UUID.randomUUID());
        car.setModel(jsonNode.get("model").asText());
        car.setNumber(jsonNode.get("number").asText());
        car.setStatus(jsonNode.get("status").asInt());
        car.setPacsid(UUID.fromString(jsonNode.get("pacsid").asText()));
        carRepository.save(car);
    }
    @GetMapping("/cars")
    @ResponseBody
    @Async
    public String getAllCars(@RequestParam(value="pageno") int page, Model model) {
        model.addAttribute("name",carRepository.findAll(PageRequest.of(page, 10, Sort.by("model"))).toList());
        return "cars";
    }

}

