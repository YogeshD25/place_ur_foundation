package com.placeur.foundation.repository;


import ch.hsr.geohash.GeoHash;
import com.placeur.foundation.model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {

    Page<Place> findByPlaceName(String placeName, Pageable pageable);

//    @Query("SELECT"
//            + " p "
//            + " FROM Place p"
//            + " WHERE p.placeLat BETWEEN :southWestLat AND :northEastLat"
//            + " AND p.placeLong BETWEEN :southWestLon AND :northEastLon")
//    List<Place> findRealtyClustersWithinBounds(
//            @Param("southWestLat") double southWestLat,
//            @Param("southWestLon") double southWestLon,
//            @Param("northEastLat") double northEastLat,
//            @Param("northEastLon") double northEastLon);


    @Query("SELECT p FROM Place p WHERE p.geoHash IN(:one,:two,:three,:four,:five,:six,:seven,:eight,:nine)")
    List<Place> findRealtyClustersWithinGeoHash(
            @Param("one") String one,
            @Param("two") String two,
            @Param("three") String three,
            @Param("four") String four,
            @Param("five") String five,
            @Param("six") String six,
            @Param("seven") String seven,
            @Param("eight") String eight,
            @Param("nine") String nine);

}
