package com.placeur.foundation.repository;

import com.placeur.foundation.model.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query("SELECT r from Rating r WHERE r.placeId = :placeId")
    Page<Rating> findRatingByPlaceId(@Param("placeId") long placeId,
                                     Pageable pageable);

    @Query(nativeQuery = true,value = "SELECT * from review_rating r WHERE r.place_id = :placeId ORDER BY r.review_id DESC limit 4")
    List<Rating> findRatingLimitedByPlaceId(@Param("placeId") long placeId);

}
