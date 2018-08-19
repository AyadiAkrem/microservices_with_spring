package com.itdeep.micorservices.socialmathematics.multiplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Stores information to identify the user.
 */
@Entity
public class User {

    private final String alias;

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
}
