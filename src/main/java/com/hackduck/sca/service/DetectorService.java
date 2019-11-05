package com.hackduck.sca.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hackduck.sca.model.Detector;
import com.hackduck.sca.repository.DetectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class DetectorService {
    @Autowired
    DetectorRepository detectorRepository;
    @PostMapping("/detectors")
    public void insertCustomers() {
        Detector detector=new Detector();
        detector.setIddetector(UUID.randomUUID());
        detector.setDesc("ADSADSADASD");
        detector.setStreet("asdsa");
        detector.setStatus(1);
        detectorRepository.save(detector);

        System.out.println("SADSADASD");
    }

    @GetMapping("/detectors")
    public String getCustomers() {

       return new GsonBuilder().create().toJson(detectorRepository.findAll());

    }

}
