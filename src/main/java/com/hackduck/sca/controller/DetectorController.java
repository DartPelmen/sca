package com.hackduck.sca.controller;

import com.google.gson.GsonBuilder;
import com.hackduck.sca.model.Detector;
import com.hackduck.sca.repository.DetectorRepository;
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
public class DetectorController {
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
    @GetMapping("/detectors/pages/{pageno}")
    @ResponseBody
    public List<Detector> getAllCars(@PathVariable("pageno") int pageno, HttpServletRequest req, HttpServletResponse res) throws ServletException {
        return detectorRepository.findAll(PageRequest.of(pageno,10, Sort.by("street"))).toList();
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
