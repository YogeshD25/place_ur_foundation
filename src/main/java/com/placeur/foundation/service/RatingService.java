package com.placeur.foundation.service;

import com.placeur.foundation.model.Rating;
import com.placeur.foundation.repository.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class RatingService {
    private RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void saveCategory(Rating rating) {
        log.info("Inside Rating Service for Saving Rating");
        ratingRepository.save(rating);
    }

    public Page<Rating> getAllRatingByPlaceId(long id, Pageable page) {
        log.info("Inside Rating Service for getting all Rating By Id");
        return ratingRepository.findRatingByPlaceId(id,page);
    }


}
