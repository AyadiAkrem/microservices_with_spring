package com.itdeep.micorservices.socialmathematics.multiplication.controller;

import com.itdeep.micorservices.socialmathematics.multiplication.domain.Multiplication;
import com.itdeep.micorservices.socialmathematics.multiplication.service.MultiplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * @author Akrem AYADI
 */
@RestController
@RequestMapping("/multiplications")
final class MultiplicationController {

    private final MultiplicationService multiplicationService;

    /**
     * Starting from Spring Framework 4.3, it's very easy to write components
     * that use constructor injections. The @Autowired annotation is no longer
     * mandatory as long as the Component have a single constructor. Spring will
     * consider it an autowire target.
     *
     * @param multiplicationService : it will be injected automatically by
     * Spring
     */
    public MultiplicationController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @GetMapping("/random")
    Multiplication getRandomMultiplication() {
        return multiplicationService.createRandomMultiplication();
    }

}
