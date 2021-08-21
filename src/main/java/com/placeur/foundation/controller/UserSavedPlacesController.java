package com.placeur.foundation.controller;

import com.placeur.foundation.model.Place;
import com.placeur.foundation.model.UserSavedPlaces;
import com.placeur.foundation.service.UserSavedPlacesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/saved")
@Slf4j
public class UserSavedPlacesController {

    private final UserSavedPlacesService userSavedPlacesService;

    @Autowired
    public UserSavedPlacesController(UserSavedPlacesService userSavedPlacesService) {
        this.userSavedPlacesService = userSavedPlacesService;
    }

    @GetMapping
    public List<Place> getAllSavedPlacesByUsername(@RequestParam String username) {
        log.info("Inside UserSavedPlaces Controller in getAllSavedPlacesByUsername");
        return userSavedPlacesService.getUserSavedPlaces(username);
    }

    @PostMapping
    public void savePlaceByUsernamePlaceId(@RequestBody UserSavedPlaces userSavedPlaces) {
        log.info("Inside UserSavedPlaces Controller in savePlaceByUsernamePlaceId");
        userSavedPlacesService.saveUserSavedPlaces(userSavedPlaces);
    }

    @PostMapping
    @RequestMapping(path = "/delete")
    public void deleteSavedPlaceByUsernamePlaceId(@RequestBody UserSavedPlaces userSavedPlaces) {
        log.info("Inside UserSavedPlaces Controller in deleteSavedPlaceByUsernamePlaceId");
        userSavedPlacesService.deleteSavedPlace(userSavedPlaces);
    }
}
