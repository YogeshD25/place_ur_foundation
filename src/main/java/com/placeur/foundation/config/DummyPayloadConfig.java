package com.placeur.foundation.config;


import com.placeur.foundation.model.Category;
import com.placeur.foundation.model.Place;
import com.placeur.foundation.repository.CategoryRepository;
import com.placeur.foundation.repository.PlaceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DummyPayloadConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlaceRepository placeRepository,
                                        CategoryRepository categoryRepository) {
        return args -> {


            //Added Dummy Places
            List<Place> placeArrayList = new ArrayList<>();
            placeArrayList.add(new Place(111, "Mc Donalds",1L,"91","92",
                    "Best place","https://picsum.photos/seed/picsum/200/300"));
            placeArrayList.add(new Place(1112, "Burger Singh",1L,"91","92",
                    "Best place","https://picsum.photos/seed/picsum/200/300"));

            placeRepository.saveAll(placeArrayList);


            //Added Dummy Categories
            List<Category> categoryArrayList = new ArrayList<>();
            categoryArrayList.add(new Category(1L, "Restaurant",
                    "https://picsum.photos/200/300?grayscale"));
            categoryArrayList.add(new Category(2L, "Coffee Shops",
                    "https://picsum.photos/200/300?grayscale"));
            categoryArrayList.add(new Category(3L, "Shopping",
                    "https://picsum.photos/200/300?grayscale"));
            categoryArrayList.add(new Category(4L, "Pubs",
                    "https://picsum.photos/200/300?grayscale"));
            categoryArrayList.add(new Category(5L, "Bars",
                    "https://picsum.photos/200/300?grayscale"));
            categoryArrayList.add(new Category(6L, "Hair Salons",
                    "https://picsum.photos/200/300?grayscale"));
            categoryRepository.saveAll(categoryArrayList);
        };
    }
}
