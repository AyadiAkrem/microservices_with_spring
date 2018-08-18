package com.itdeep.micorservices.socialmathematics.multiplication.service;

import com.itdeep.micorservices.socialmathematics.multiplication.domain.Multiplication;
import com.itdeep.micorservices.socialmathematics.multiplication.domain.MultiplicationResultAttempt;
import org.springframework.stereotype.Service;

@Service
final class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;

    /**
     *
     * @param randomGeneratorService will be injected automatically by Spring as
     * long as this class have only this constructor
     */
    public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {
        return resultAttempt.getResultAttempt()
                == resultAttempt.getMultiplication().getFactorA()
                * resultAttempt.getMultiplication().getFactorB();
    }

}
