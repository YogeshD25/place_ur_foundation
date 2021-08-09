package com.placeur.foundation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "place_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long categoryId;
    @Column
    private String categoryName;
    @Column
    private String categoryImageUrl;
    @Column
    private String categorySecondaryImageUrl;

}
