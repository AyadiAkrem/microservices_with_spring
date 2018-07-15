package com.itdeep.micorservices.socialmathematics.multiplication.domain;

/**
 *
 * @author EXG503
 */
public class Event {
    
    private final Double latitude ;
    
    private final Double longitude ;
    
    private final Integer within ;

    public Event(Double latitude, Double longitude, Integer within) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.within = within;
    }

    public Event() {
        this(null,null,null);
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Integer getWithin() {
        return within;
    }
    
    
    
}
