package com.placeur.foundation.controller;

import com.placeur.foundation.model.Rating;
import com.placeur.foundation.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/rating")
@Slf4j
public class RatingController {

    private RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> uploadFile(@RequestPart(value = "file", required = true) MultipartFile[] files,
                                          @RequestPart(value = "ratingId", required = true) String ratingId)  {
        String name = ratingService.uploadRatingImages(files, "prefix", ratingId);
        if(name!=null){
            return new ResponseEntity<>("Image Uploaded Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Image Upload Failed", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/paging")
    public ResponseEntity<Map<String, Object>> getAllRatingByPaging(
            @RequestParam long placeId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        try {
            List<Rating> ratingList = new ArrayList<>();
            Pageable paging = PageRequest.of(page, size);
            Page<Rating> pageTuts;
            pageTuts = ratingService.getAllRatingByPlaceId(placeId, paging);
            ratingList = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("rating", ratingList);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public void saveRating(@RequestBody Rating rating) {
        log.info("Inside Rating Controller in saveRating");
        ratingService.saveCategory(rating);
    }

}
