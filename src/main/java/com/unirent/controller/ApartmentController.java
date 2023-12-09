package com.unirent.controller;

import com.unirent.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/apartments")
@CrossOrigin("http://localhost:5173")
public class ApartmentController {

    private final ApartmentService apartmentService;

    @GetMapping("/search/cities")
    public List<String> getDistinctCities() {
        return apartmentService.findDistinctCities();
    }

}
