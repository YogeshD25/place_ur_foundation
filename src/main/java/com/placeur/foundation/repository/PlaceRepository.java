package com.placeur.foundation.repository;


import com.placeur.foundation.model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {

    Page<Place> findByPlaceName(String placeName, Pageable pageable);
}
