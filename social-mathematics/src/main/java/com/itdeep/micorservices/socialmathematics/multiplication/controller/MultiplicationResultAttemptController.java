package com.itdeep.micorservices.socialmathematics.multiplication.controller;

import com.itdeep.micorservices.socialmathematics.multiplication.domain.MultiplicationResultAttempt;
import com.itdeep.micorservices.socialmathematics.multiplication.service.MultiplicationService;
import java.util.Collections;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller check the result being Posted by users and return if its
 * correct or not
 *
 * @author Akrem AYADI
 */
@RestController
@RequestMapping("/results")
final class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;

    /**
     *
     * @param multiplicationService will be injected automatically by Spring as
     * long as this class have only this constructor
     */
    public MultiplicationResultAttemptController(final MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }
    
    @PostMapping
     public ResponseEntity<Map> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
        return ResponseEntity.ok(Collections.singletonMap("Result", multiplicationService.checkAttempt(multiplicationResultAttempt)));
        
    }

}
