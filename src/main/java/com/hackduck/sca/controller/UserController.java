package com.hackduck.sca.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackduck.sca.model.User;
import com.hackduck.sca.repository.CarRepository;
import com.hackduck.sca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CarRepository carRepository;

    @PostMapping("/users")
    public void insertUser(@RequestBody String postedUser) throws JsonProcessingException {
        User user= new User();
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(postedUser);
        user.setIduser(UUID.randomUUID());
        user.setFname(jsonNode.get("fname").asText());
        user.setSname(jsonNode.get("sname").asText());
        user.setLname(jsonNode.get("lname").asText());
        user.setStatus(jsonNode.get("status").asInt());
        user.setPacsid(UUID.fromString(jsonNode.get("pacsid").asText()));
        userRepository.save(user);
    }


    @GetMapping("/users/pages/{pageno}")
    @ResponseBody
    public List<User> getAllCars(@PathVariable("pageno") int pageno) {
        return userRepository.findAll(PageRequest.of(pageno,10, Sort.by("lname").descending().and(Sort.by("fname")).descending().and(Sort.by("sname")))).toList();
    }


}
