package com.hackduck.sca.controller;

import com.google.gson.GsonBuilder;
import com.hackduck.sca.model.Detector;
import com.hackduck.sca.repository.DetectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
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
    @GetMapping("/")
    @ResponseBody
    public String geHello() {
        return "Hello!";
    }
    @GetMapping("/detectors{id}")
    public String getCustomers(String id) {

         return new GsonBuilder().create().toJson(detectorRepository.findById(UUID.fromString(id)));

    }
    @GetMapping("/detectors")
    public String getAllCars(@RequestParam(value="page", defaultValue = "0") int page, Model model) {
        model.addAttribute("detectors",detectorRepository.findAll(PageRequest.of(page,10, Sort.by("street"))).toList());
        return "detectors.html";
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
