package com.placeur.foundation.controller;


import com.placeur.foundation.model.Place;
import com.placeur.foundation.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/place")
@Slf4j
public class PlaceController {

    private PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<Place> getAllPlace() {
        log.info("Inside Place Controller in getAllPlace");
        return placeService.getAllPlace();
    }

    @PostMapping
    public void savePlace(@RequestBody Place place) {
        log.info("Inside Place Controller in savePlace");
        placeService.savePlace(place);
    }


}
