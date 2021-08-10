package com.placeur.foundation.config;


import com.placeur.foundation.model.Category;
import com.placeur.foundation.model.Place;
import com.placeur.foundation.model.UserProfile;
import com.placeur.foundation.repository.CategoryRepository;
import com.placeur.foundation.repository.PlaceRepository;
import com.placeur.foundation.repository.UserRepository;
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
                                        UserRepository userRepository) {
        return args -> {


            //Added Dummy Places
            List<Place> placeArrayList = new ArrayList<>();
            placeArrayList.add(new Place(111, "Raddison Blu",1L,"21.2458","79.0882",
                    "Best place","https://i.ibb.co/nLDLJrH/restaurent-4.png",4.4f));
            placeArrayList.add(new Place(1112, "Ovenstory Pizza",1L,"21.3458","79.0882",
                    "Best place","https://i.ibb.co/rbmNQfd/restaurent-1.png",3.7f));
            placeArrayList.add(new Place(1113, "Subway",1L,"21.4458","79.0882",
                    "Best place","https://i.ibb.co/CKmzxDv/restaurent-3.png",2.7f));
            placeArrayList.add(new Place(1114, "BBQ",1L,"21.5458","79.0882",
                    "Best place","https://i.ibb.co/xLRwbfW/restaurent-2.png",3.2f));


            placeRepository.saveAll(placeArrayList);

            //Added Default user
            userRepository.save(new UserProfile(1,"vineet","vineet@gmail.com",
                    "$2a$10$VdrfGWdFiAs1/WpI49IeOeWElSKZePARcG7f7d1fO4RvsqG8NJMCS","7894564874"));

            //Added Dummy Categories
            List<Category> categoryArrayList = new ArrayList<>();
            categoryArrayList.add(new Category(1L, "Restaurant",
                    "https://i.ibb.co/HzKG343/Top-view-table-full-of-food-Sharing-dinner-with-friends.jpg","https://i.ibb.co/tCY7WQq/restaurants.png"));
            categoryArrayList.add(new Category(2L, "Coffee Shops",
                    "https://i.ibb.co/rydknC6/Coffee-Shops.jpg","https://i.ibb.co/2s37d74/coffee.png"));
            categoryArrayList.add(new Category(3L, "Shopping",
                    "https://i.ibb.co/DC2P1Hr/Shopping.jpg","https://i.ibb.co/ysDP8cs/shopping.png"));
            categoryArrayList.add(new Category(4L, "Pubs",
                    "https://i.ibb.co/Tm2HGgk/pubs.jpg","https://i.ibb.co/Q9VbhgW/pubs.png"));
            categoryArrayList.add(new Category(5L, "Bars",
                    "https://i.ibb.co/mGS1QhN/bars.jpg","https://i.ibb.co/DVmC7zZ/bars.png"));
            categoryArrayList.add(new Category(6L, "Hair Salons",
                    "https://i.ibb.co/cNNNhsd/hairsalon.jpg","https://i.ibb.co/VLLGD70/hair.png"));
            categoryRepository.saveAll(categoryArrayList);
        };
    }
}
