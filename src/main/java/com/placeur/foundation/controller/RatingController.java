package com.placeur.foundation.controller;

import com.placeur.foundation.model.Rating;
import com.placeur.foundation.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rating")
@Slf4j
public class RatingController {

    private RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public List<Rating> getAllRatingByPlaceId(@RequestParam long id) {
        log.info("Inside Rating Controller in getAllRatingByPlaceId");
        return ratingService.getAllRatingByPlaceId(id);
    }

    @PostMapping
    public void savePlace(@RequestBody Rating rating) {
        log.info("Inside Rating Controller in saveRating");
        ratingService.saveCategory(rating);
    }

}
