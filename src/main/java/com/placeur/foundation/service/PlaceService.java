package com.placeur.foundation.service;


import com.placeur.foundation.model.Place;
import com.placeur.foundation.repository.PlaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlaceService {


    public PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public void savePlace(Place place){
        log.info("Inside Place Service for Saving place");
        placeRepository.save(place);
    }

    public List<Place> getAllPlace(){
        log.info("Inside Place Service for getting all places");
        return placeRepository.findAll();
    }
}
