package com.itdeep.micorservices.socialmathematics.multiplication.domain;

/**
 * Stores information to identify the user.
 */
public final class User {

    private final String alias;

    // Empty constructor for JSON (de)serialization
    protected User() {
        alias = null;
    }

    public User(String alias) {
        this.alias = alias;
    }
    
    
}
