package com.placeur.foundation.config;


import com.placeur.foundation.model.Category;
import com.placeur.foundation.model.Place;
import com.placeur.foundation.repository.CategoryRepository;
import com.placeur.foundation.repository.PlaceRepository;
import com.placeur.foundation.service.PlaceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DummyPayloadConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlaceRepository placeRepository,
                                        CategoryRepository categoryRepository,
                                        PlaceService placeService) {
        return args -> {


            //Added Dummy Places
            List<Place> placeArrayList = new ArrayList<>();

            placeArrayList.add(new Place(111, "Raddison Blu",1L,20.104549,77.132677,
                    "Best place","https://i.ibb.co/4FfPXZk/raddison.jpg","",4.4f));
            placeArrayList.add(new Place(1112, "Ovenstory Pizza",1L,20.104710,77.132935,
                    "Best place","https://i.ibb.co/0sT6rL1/ovenstory.jpg","",3.7f));
            placeArrayList.add(new Place(1113, "Subway",1L,20.710391,77.062419,
                    "Best place","https://i.ibb.co/t4K4T20/subway.jpg","",2.7f));
            placeArrayList.add(new Place(1114, "BBQ",1L,21.004522,74.349907,
                    "Best place","https://i.ibb.co/tZdZhfH/bbq.jpg","",3.2f));


            for (Place place: placeArrayList) {
                placeService.savePlace(place);
            }

//            placeRepository.saveAll(placeArrayList);


            //Added Dummy Categories
            List<Category> categoryArrayList = new ArrayList<>();
            categoryArrayList.add(new Category(1L, "Restaurant",
                    "https://i.ibb.co/GQvBPXK/Top-view-table-full-of-food-Sharing-dinner-with-friends.jpg","https://i.ibb.co/GQvBPXK/Top-view-table-full-of-food-Sharing-dinner-with-friends.jpg"));
            categoryArrayList.add(new Category(2L, "Coffee Shops",
                    "https://i.ibb.co/41kFQyM/Coffee-Shops.jpg","https://i.ibb.co/41kFQyM/Coffee-Shops.jpg"));
            categoryArrayList.add(new Category(3L, "Shopping",
                    "https://i.ibb.co/vhkg5tb/Shopping.jpg","https://i.ibb.co/vhkg5tb/Shopping.jpg"));
            categoryArrayList.add(new Category(4L, "Pubs",
                    "https://i.ibb.co/T13FsKc/pubs.jpg","https://i.ibb.co/T13FsKc/pubs.jpg"));
            categoryArrayList.add(new Category(5L, "Bars",
                    "https://i.ibb.co/jvgJBmk/bars.jpg","https://i.ibb.co/jvgJBmk/bars.jpg"));
            categoryArrayList.add(new Category(6L, "Hair Salons",
                    "https://i.ibb.co/Prs7cTY/hairsalon.jpg","https://i.ibb.co/Prs7cTY/hairsalon.jpg"));
            categoryRepository.saveAll(categoryArrayList);
        };
    }
}
