package com.hackduck.sca.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackduck.sca.model.Detector;
import com.hackduck.sca.repository.DetectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class DetectorService {
    @Autowired
    DetectorRepository detectorRepository;
    @PostMapping("/new-detector")
    public void insertCustomers() {
        Detector detector=new Detector();
        detector.setIddetector(UUID.randomUUID());
        detector.setDesc("ADSADSADASD");
        detector.setStreet("asdsa");
        detector.setStatus(1);
        detectorRepository.save(detector);

        System.out.println("SADSADASD");
    }

    @GetMapping("/detectors{id}")
    public String getCustomers(String id) {

         return new GsonBuilder().create().toJson(detectorRepository.findById(UUID.fromString(id)));

    }
    @GetMapping("/detectors")
    public String getCustomers() {
        return new GsonBuilder().create().toJson(detectorRepository.findAll());
    }


    @PostMapping(value = "/edit-detector")
    public void updateCustomers(@RequestParam (value = "id") String id) {


        Detector detector=detectorRepository.findByIddetector(UUID.fromString(id));
        System.out.println("GOT "+detector.getIddetector());
        detector.setDesc("EDIT");
        detector.setStatus(2);
        detector.setStreet("STREET");
        detectorRepository.save(detector);
    }

}
