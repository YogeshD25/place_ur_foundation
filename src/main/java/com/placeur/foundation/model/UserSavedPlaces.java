package com.placeur.foundation.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_saved_places")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CompositeKey.class)
public class UserSavedPlaces {

    @Column
    @Id
    private String username;

    @Column
    @Id
    private long placeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserSavedPlaces that = (UserSavedPlaces) o;

        if (!Objects.equals(username, that.username)) return false;
        return placeId == that.placeId;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(username);
        result = 31 * result + (int) (placeId ^ (placeId >>> 32));
        return result;
    }
}
