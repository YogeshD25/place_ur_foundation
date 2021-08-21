package com.placeur.foundation.repository;

import com.placeur.foundation.model.CompositeKey;
import com.placeur.foundation.model.Place;
import com.placeur.foundation.model.UserSavedPlaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSavedPlacesRepository extends JpaRepository<UserSavedPlaces, CompositeKey> {

    @Query("SELECT p FROM Place p INNER JOIN UserSavedPlaces usp ON p.placeId = usp.placeId where usp.username = :username")
    List<Place> getSavedPlacesByUsername(@Param("username") String username);
}
