package com.placeur.foundation.repository;

import com.placeur.foundation.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query("SELECT r from Rating r WHERE r.placeId = :placeId")
    List<Rating> findRatingByPlaceId(@Param("placeId") long placeId);

}
