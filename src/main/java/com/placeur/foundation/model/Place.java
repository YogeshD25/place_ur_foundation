package com.placeur.foundation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "point_of_interest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @Id
    @SequenceGenerator(
            name = "place_sequence",
            sequenceName = "place_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "place_sequence"
    )
    private long placeId;
    @Column
    private String placeName;
    @Column
    private long categoryId;
    @Column
    private String categoryName;
    @Column
    private double placeLat;
    @Column
    private double placeLong;
    @Column
    private String placeDescription;
    @Column
    private String placeImageUrl;
    @Column
    private String geoHash;
    @Column
    private float placeRating;
    @Column
    private String placeCity;
    @Column
    private String placePricing;
}
