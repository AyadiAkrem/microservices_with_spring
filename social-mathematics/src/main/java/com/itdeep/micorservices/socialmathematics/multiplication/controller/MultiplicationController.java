/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdeep.micorservices.socialmathematics.multiplication.controller;

import com.itdeep.micorservices.socialmathematics.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author EXG503
 */
@RestController
public class MultiplicationController {
    
    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }
    
    
    
}
