package com.placeur.foundation.repository;


import com.placeur.foundation.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, String> {

    //    UserProfile findByMobileNumber(String userMobile);
    UserProfile findByUsername(String userName);


}
