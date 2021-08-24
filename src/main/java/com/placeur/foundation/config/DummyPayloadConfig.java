package com.placeur.foundation.config;


import com.placeur.foundation.model.*;
import com.placeur.foundation.repository.CategoryRepository;
import com.placeur.foundation.service.PlaceService;
import com.placeur.foundation.service.RatingService;
import com.placeur.foundation.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DummyPayloadConfig {

    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository categoryRepository,
                                        PlaceService placeService,
                                        UserService userService,
                                        RatingService ratingService
                                        ) {
        return args -> {



            List<UserDto> userList = new ArrayList<>();
            userList.add(new UserDto("yogesh", "123", "7385787937", "yogesh@gmail.com"));
            userList.add(new UserDto("vineet", "123", "1234567890", "vineet@gmail.com"));
            userService.save(userList.get(0));
            userService.save(userList.get(1));

            //Added Dummy Places
            List<Place> placeArrayList = new ArrayList<>();

            placeArrayList.add(new Place(111, "Raddison Blu", 1L,"Restaurant", 20.104549, 77.132677,
                    "Best place", "https://i.ibb.co/rbmNQfd/restaurent-1.png", "", 4.4f,"Washim","₹₹"));
            placeArrayList.add(new Place(1112, "Ovenstory Pizza", 1L,"Restaurant", 20.104710, 77.132935,
                    "Best place", "https://i.ibb.co/xLRwbfW/restaurent-2.png", "", 3.7f,"Washim","₹₹₹₹"));

            placeArrayList.add(new Place(113, "Jackson Blu", 1L,"Restaurant", 20.105549, 77.132677,
                    "Best place", "https://i.ibb.co/rbmNQfd/restaurent-1.png", "", 2.4f,"Washim","₹₹"));
            placeArrayList.add(new Place(1114, "CrazyStory Hut", 1L,"Restaurant", 20.104810, 77.132935,
                    "Best place", "https://i.ibb.co/xLRwbfW/restaurent-2.png", "", 3.2f,"Washim","₹₹"));
            placeArrayList.add(new Place(1115, "Raddison Blu", 1L,"Restaurant", 20.104519, 77.132677,
                    "Best place", "https://i.ibb.co/rbmNQfd/restaurent-1.png", "", 4.9f,"Washim","₹₹"));
            placeArrayList.add(new Place(1116, "Devil Pizza", 1L,"Restaurant", 20.104700, 77.132935,
                    "Best place", "https://i.ibb.co/xLRwbfW/restaurent-2.png", "", 3.7f,"Washim","₹₹"));
            placeArrayList.add(new Place(1117, "Mac D ", 1L,"Restaurant", 20.104529, 77.132677,
                    "Best place", "https://i.ibb.co/rbmNQfd/restaurent-1.png", "", 1.4f,"Washim","₹₹"));
            placeArrayList.add(new Place(1118, "Food Carter", 1L,"Restaurant", 20.104220, 77.132935,
                    "Best place", "https://i.ibb.co/xLRwbfW/restaurent-2.png", "", 3.7f,"Washim","₹₹"));

            placeArrayList.add(new Place(113, "Jackson Blu 1", 1L,"Restaurant", 20.105549, 77.152677,
                    "Best place", "https://i.ibb.co/rbmNQfd/restaurent-1.png", "", 2.4f,"Washim","₹₹"));
            placeArrayList.add(new Place(1114, "CrazyStory Hut 1", 1L,"Restaurant", 20.104810, 77.142935,
                    "Best place", "https://i.ibb.co/xLRwbfW/restaurent-2.png", "", 3.2f,"Washim","₹₹"));
            placeArrayList.add(new Place(1115, "Raddison Blu 1", 1L,"Restaurant", 20.104519, 77.133677,
                    "Best place", "https://i.ibb.co/rbmNQfd/restaurent-1.png", "", 4.9f,"Washim","₹₹"));
            placeArrayList.add(new Place(1116, "Devil Pizza 1", 1L,"Restaurant", 20.104720, 77.132635,
                    "Best place", "https://i.ibb.co/xLRwbfW/restaurent-2.png", "", 3.7f,"Washim","₹₹"));
            placeArrayList.add(new Place(1117, "Mac D 1", 1L,"Restaurant", 20.104529, 77.132677,
                    "Best place", "https://i.ibb.co/rbmNQfd/restaurent-1.png", "", 1.4f,"Washim","₹₹"));
            placeArrayList.add(new Place(1118, "Food Carter 1", 1L,"Restaurant", 20.104250, 77.132935,
                    "Best place", "https://i.ibb.co/xLRwbfW/restaurent-2.png", "", 3.7f,"Washim","₹₹"));

            placeArrayList.add(new Place(113, "Jackson Blu 2", 1L,"Restaurant", 20.104489, 77.132277,
                    "Best place", "https://i.ibb.co/rbmNQfd/restaurent-1.png", "", 2.4f,"Washim","₹₹"));
            placeArrayList.add(new Place(1114, "CrazyStory Hut 2", 1L,"Restaurant", 20.107810, 77.132035,
                    "Best place", "https://i.ibb.co/xLRwbfW/restaurent-2.png", "", 3.2f,"Washim","₹₹"));
            placeArrayList.add(new Place(1115, "Raddison Blu 2", 1L,"Restaurant", 20.105519, 77.132177,
                    "Best place", "https://i.ibb.co/rbmNQfd/restaurent-1.png", "", 4.9f,"Washim","₹₹"));
            placeArrayList.add(new Place(1116, "Devil Pizza 2", 1L,"Restaurant", 20.124700, 77.132435,
                    "Best place", "https://i.ibb.co/xLRwbfW/restaurent-2.png", "", 3.7f,"Washim","₹₹"));
            placeArrayList.add(new Place(1117, "Mac D 2", 1L,"Restaurant", 20.114529, 77.132677,
                    "Best place", "https://i.ibb.co/rbmNQfd/restaurent-1.png", "", 1.4f,"Washim","₹₹"));
            placeArrayList.add(new Place(1118, "Food Carter 2", 1L,"Restaurant", 20.104230, 77.132735,
                    "Best place", "https://i.ibb.co/xLRwbfW/restaurent-2.png", "", 3.7f,"Washim","₹₹"));

            placeArrayList.add(new Place(1113, "Subway", 1L,"Restaurant", 21.1441, 79.0882,
                    "Best place", "https://i.ibb.co/CKmzxDv/restaurent-3.png", "", 2.7f,"Nagpur","₹₹"));
            placeArrayList.add(new Place(1114, "BBQ", 1L,"Restaurant", 21.1341, 79.0782,
                    "Best place", "https://i.ibb.co/nLDLJrH/restaurent-4.png", "", 3.2f,"Nagpur","₹"));

            placeArrayList.add(new Place(1113, "Subway Nag", 1L,"Restaurant", 21.1451, 79.0862,
                    "Best place", "https://i.ibb.co/CKmzxDv/restaurent-3.png", "", 4.7f,"Nagpur","₹₹₹₹"));
            placeArrayList.add(new Place(1114, "BBQ Nag", 1L,"Restaurant", 21.1345, 79.0783,
                    "Best place", "https://i.ibb.co/nLDLJrH/restaurent-4.png", "", 1.2f,"Nagpur","₹₹₹"));
            placeArrayList.add(new Place(1113, "Subway Nag 2", 1L,"Restaurant", 21.1421, 79.0892,
                    "Best place", "https://i.ibb.co/CKmzxDv/restaurent-3.png", "", 2.7f,"Nagpur","₹₹₹"));
            placeArrayList.add(new Place(1114, "BBQ Nag 2", 1L,"Restaurant", 21.1347, 79.0782,
                    "Best place", "https://i.ibb.co/nLDLJrH/restaurent-4.png", "", 3.2f,"Nagpur","₹₹₹"));
            placeArrayList.add(new Place(1113, "Subway Nag 3", 1L,"Restaurant", 21.1443, 79.0842,
                    "Best place", "https://i.ibb.co/CKmzxDv/restaurent-3.png", "", 2.7f,"Nagpur","₹₹₹"));
            placeArrayList.add(new Place(1114, "BBQ Nag 3", 1L,"Restaurant", 21.1342, 79.0762,
                    "Best place", "https://i.ibb.co/nLDLJrH/restaurent-4.png", "", 3.2f,"Nagpur","₹₹₹"));


            for (Place place : placeArrayList) {
                placeService.savePlace(place);
            }

//            placeRepository.saveAll(placeArrayList);

            //Added Dummy Categories
            List<Category> categoryArrayList = new ArrayList<>();
            categoryArrayList.add(new Category(1L, "Restaurant",
                    "https://i.ibb.co/HzKG343/Top-view-table-full-of-food-Sharing-dinner-with-friends.jpg", "https://i.ibb.co/tCY7WQq/restaurants.png"));
            categoryArrayList.add(new Category(2L, "Coffee Shops",
                    "https://i.ibb.co/rydknC6/Coffee-Shops.jpg", "https://i.ibb.co/2s37d74/coffee.png"));
            categoryArrayList.add(new Category(3L, "Shopping",
                    "https://i.ibb.co/DC2P1Hr/Shopping.jpg", "https://i.ibb.co/ysDP8cs/shopping.png"));
            categoryArrayList.add(new Category(4L, "Pubs",
                    "https://i.ibb.co/Tm2HGgk/pubs.jpg", "https://i.ibb.co/Q9VbhgW/pubs.png"));
            categoryArrayList.add(new Category(5L, "Bars",
                    "https://i.ibb.co/mGS1QhN/bars.jpg", "https://i.ibb.co/DVmC7zZ/bars.png"));
            categoryArrayList.add(new Category(6L, "Hair Salons",
                    "https://i.ibb.co/cNNNhsd/hairsalon.jpg", "https://i.ibb.co/VLLGD70/hair.png"));
            categoryRepository.saveAll(categoryArrayList);



            ratingService.saveCategory(new Rating(1L,1L,"7385787937","Awesome place to visit",4.1f, new Date(System.currentTimeMillis()),"https://i.ibb.co/cNNNhsd/hairsalon.jpg"));
            ratingService.saveCategory(new Rating(2L,1L,"7385787937","Awesome place to visit Must have visit the place as it is cool as GTA video game",4.1f, new Date(System.currentTimeMillis()),"https://i.ibb.co/cNNNhsd/hairsalon.jpg"));
        };
    }
}
