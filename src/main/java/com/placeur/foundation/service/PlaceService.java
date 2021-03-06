package com.placeur.foundation.service;


import ch.hsr.geohash.GeoHash;
import com.azure.storage.blob.BlobClientBuilder;
import com.placeur.foundation.model.Location;
import com.placeur.foundation.model.Place;
import com.placeur.foundation.repository.PlaceRepository;
import com.placeur.foundation.utility.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PlaceService {


    public PlaceRepository placeRepository;

    @Autowired
    BlobClientBuilder client;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public String uploadPlaceImage(MultipartFile file, String prefixName, String placeId) {
        if(file != null && file.getSize() > 0) {
            try {
                //implement your own file name logic.
                String fileName = prefixName+ UUID.randomUUID().toString() +file.getOriginalFilename();
                client.blobName(fileName).buildClient().upload(file.getInputStream(),file.getSize());

                Place place = placeRepository.getById(Long.parseLong(placeId));
                place.setPlaceImageUrl(Constants.AZURE_STORAGE_PREDECESSOR_URL + fileName);
                placeRepository.save(place);
                return fileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Place savePlace(Place place) {
        log.info("Inside Place Service for Saving place");
        GeoHash hash = GeoHash.withBitPrecision(place.getPlaceLat(), place.getPlaceLong(), 25);
        place.setGeoHash(hash.toBase32());
       return placeRepository.save(place);
    }

    public List<Place> getAllPlace() {
        log.info("Inside Place Service for getting all places");
        return placeRepository.findAll();
    }

    public List<Place> getPlacesBasedOnLocation(double placeLat, double placeLong, int placeProximity) {

        GeoHash hash = GeoHash.withBitPrecision(placeLat, placeLong, 25);
        GeoHash[] geoHashes = hash.getAdjacent();

        log.info("Values " + geoHashes[0].toBase32() + "\n" +
                geoHashes[1].toBase32() + "\n" +
                geoHashes[2].toBase32() + "\n" +
                geoHashes[3].toBase32() + "\n" +
                geoHashes[4].toBase32() + "\n" +
                geoHashes[5].toBase32() + "\n" +
                geoHashes[6].toBase32() + "\n" +
                geoHashes[7].toBase32() + "\n" +
                hash.toBase32());

        List<Place> list = placeRepository.findRealtyClustersWithinGeoHash(
                geoHashes[0].toBase32(),
                geoHashes[1].toBase32(),
                geoHashes[2].toBase32(),
                geoHashes[3].toBase32(),
                geoHashes[4].toBase32(),
                geoHashes[5].toBase32(),
                geoHashes[6].toBase32(),
                geoHashes[7].toBase32(),
                hash.toBase32()
        );

        return list;
    }

    public Page<Place> getPlacesBasedOnLocationByPaging(Location location, Pageable paging) {

        GeoHash hash = GeoHash.withBitPrecision(location.getPlaceLat(), location.getPlaceLong(), 25);
        GeoHash[] geoHashes = hash.getAdjacent();

        log.info("Values " + geoHashes[0].toBase32() + "\n" +
                geoHashes[1].toBase32() + "\n" +
                geoHashes[2].toBase32() + "\n" +
                geoHashes[3].toBase32() + "\n" +
                geoHashes[4].toBase32() + "\n" +
                geoHashes[5].toBase32() + "\n" +
                geoHashes[6].toBase32() + "\n" +
                geoHashes[7].toBase32() + "\n" +
                hash.toBase32());

        Page<Place> list = placeRepository.findRealtyClustersWithinGeoHashByPaging(
                geoHashes[0].toBase32(),
                geoHashes[1].toBase32(),
                geoHashes[2].toBase32(),
                geoHashes[3].toBase32(),
                geoHashes[4].toBase32(),
                geoHashes[5].toBase32(),
                geoHashes[6].toBase32(),
                geoHashes[7].toBase32(),
                hash.toBase32(),paging

        );
        return list;
    }

    public List<Place> getPlacesBasedOnLocationByPlaceName(Location location) {

        GeoHash hash = GeoHash.withBitPrecision(location.getPlaceLat(), location.getPlaceLong(), 25);
        GeoHash[] geoHashes = hash.getAdjacent();

        log.info("Values " + geoHashes[0].toBase32() + "\n" +
                geoHashes[1].toBase32() + "\n" +
                geoHashes[2].toBase32() + "\n" +
                geoHashes[3].toBase32() + "\n" +
                geoHashes[4].toBase32() + "\n" +
                geoHashes[5].toBase32() + "\n" +
                geoHashes[6].toBase32() + "\n" +
                geoHashes[7].toBase32() + "\n" +
                hash.toBase32());

        List<Place> list = placeRepository.findRealtyClustersWithinGeoHashByPlaceName(
                geoHashes[0].toBase32(),
                geoHashes[1].toBase32(),
                geoHashes[2].toBase32(),
                geoHashes[3].toBase32(),
                geoHashes[4].toBase32(),
                geoHashes[5].toBase32(),
                geoHashes[6].toBase32(),
                geoHashes[7].toBase32(),
                hash.toBase32(),
                location.getPlaceName()
        );
        return list;
    }

    public Page<Place> getPlacesBasedOnLocationPagingByCategoryId(Location location, Pageable paging) {

        GeoHash hash = GeoHash.withBitPrecision(location.getPlaceLat(), location.getPlaceLong(), 25);
        GeoHash[] geoHashes = hash.getAdjacent();

        log.info("Values " + geoHashes[0].toBase32() + "\n" +
                geoHashes[1].toBase32() + "\n" +
                geoHashes[2].toBase32() + "\n" +
                geoHashes[3].toBase32() + "\n" +
                geoHashes[4].toBase32() + "\n" +
                geoHashes[5].toBase32() + "\n" +
                geoHashes[6].toBase32() + "\n" +
                geoHashes[7].toBase32() + "\n" +
                hash.toBase32());

        Page<Place> list = placeRepository.findRealtyClustersWithinGeoHashByPagingWithCategoryId(
                geoHashes[0].toBase32(),
                geoHashes[1].toBase32(),
                geoHashes[2].toBase32(),
                geoHashes[3].toBase32(),
                geoHashes[4].toBase32(),
                geoHashes[5].toBase32(),
                geoHashes[6].toBase32(),
                geoHashes[7].toBase32(),
                hash.toBase32(),
                Long.parseLong(location.getCategoryId()),
                paging

        );
        return list;
    }
}
