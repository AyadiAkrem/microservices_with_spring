package com.itdeep.micorservices.socialmathematics.multiplication.service;


import com.itdeep.micorservices.socialmathematics.multiplication.domain.Event;
import com.itdeep.micorservices.socialmathematics.multiplication.domain.EventResult;
import java.util.List;

public interface EventBriteService {

    List<EventResult>  searchEvent(Event event);

    
}
