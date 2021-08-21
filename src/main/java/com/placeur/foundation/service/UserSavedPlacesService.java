package com.placeur.foundation.service;

import com.placeur.foundation.model.Place;
import com.placeur.foundation.model.UserSavedPlaces;
import com.placeur.foundation.repository.UserSavedPlacesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserSavedPlacesService {

    private final UserSavedPlacesRepository userSavedPlacesRepository;

    @Autowired
    UserSavedPlacesService(UserSavedPlacesRepository userSavedPlacesRepository) {
        this.userSavedPlacesRepository = userSavedPlacesRepository;
    }

    public void saveUserSavedPlaces(UserSavedPlaces userSavedPlaces) {
        log.info("Inside UserSavedPlaces Service for Saving user fav");
        userSavedPlacesRepository.save(userSavedPlaces);
    }

    public List<Place> getUserSavedPlaces(String username) {
        log.info("Inside UserSavedPlaces Service for getting all saved places by username");
        return userSavedPlacesRepository.getSavedPlacesByUsername(username);
    }

    public void deleteSavedPlace(UserSavedPlaces userSavedPlaces){
        log.info("Inside UserSavedPlaces Service for deleting user fav");
        userSavedPlacesRepository.delete(userSavedPlaces);
    }
}
