package com.placeur.foundation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    double placeLat;
    double placeLong;
    int placeProximity;
    String placeName;
    String categoryId;

}
