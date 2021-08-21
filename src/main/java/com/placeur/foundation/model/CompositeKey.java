package com.placeur.foundation.model;

import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

public class CompositeKey implements Serializable {

    private String username;
    private long placeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompositeKey that = (CompositeKey) o;

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