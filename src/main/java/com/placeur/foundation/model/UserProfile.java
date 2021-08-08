package com.placeur.foundation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_auth_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    @JsonIgnore
    private String password;
    @Id
    private String mobile;


}
