package com.itdeep.micorservices.socialmathematics.multiplication.domain;

import java.io.Serializable;

/**
 * Stores information to identify the user.
 */
public final class User  {

    private final String alias;

    // Empty constructor for JSON (de)serialization
    protected User() {
        this(null);
    }

    public User(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
    
    
    
}
