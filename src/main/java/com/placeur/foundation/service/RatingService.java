package com.placeur.foundation.service;

import com.azure.storage.blob.BlobClientBuilder;
import com.placeur.foundation.model.Place;
import com.placeur.foundation.model.Rating;
import com.placeur.foundation.repository.RatingRepository;
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
public class RatingService {
    private RatingRepository ratingRepository;
    @Autowired
    BlobClientBuilder client;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating saveCategory(Rating rating) {
        log.info("Inside Rating Service for Saving Rating");
        return ratingRepository.save(rating);
    }

    public Page<Rating> getAllRatingByPlaceId(long id, Pageable page) {
        log.info("Inside Rating Service for getting all Rating By Id");
        return ratingRepository.findRatingByPlaceId(id,page);
    }

    public String uploadRatingImages(MultipartFile[] files, String prefixName, String ratingId) {
        StringBuilder result = new StringBuilder();
        Rating rating = ratingRepository.getById(Long.parseLong(ratingId));
        for (MultipartFile singleFile: files) {
            if(singleFile != null && singleFile.getSize() > 0) {
                try {
                    //implement your own file name logic.
                    String fileName = prefixName+ UUID.randomUUID().toString() +singleFile.getOriginalFilename();
                    client.blobName(fileName).buildClient().upload(singleFile.getInputStream(),singleFile.getSize());

                    rating.setReviewImages(rating.getReviewImages()+","+Constants.AZURE_STORAGE_PREDECESSOR_URL + fileName);
                    ratingRepository.save(rating);
                    result.append(rating.getReviewImages());
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        }
        return result.toString();
    }


    public List<Rating> getPlaceLimitedRating(Long placeId) {
        log.info("Inside Rating Service for getting all Rating limited 4 record By Id");
        return ratingRepository.findRatingLimitedByPlaceId(placeId);
    }
}
