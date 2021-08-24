package com.placeur.foundation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "review_rating")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @SequenceGenerator(
            name = "rating_sequence",
            sequenceName = "rating_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rating_sequence"
    )
    private long reviewId;
    @Column
    @NotNull
    private long placeId;
    @Column
    @NotNull
    private String userName;
    @Column
    private String reviewDescription;
    @Column
    private float reviewStar;
    @Column
    @JsonIgnore
    private Date created_at;
    @Column(length = 1000)
    private String reviewImages;

}