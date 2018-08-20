package com.itdeep.micorservices.socialmathematics.multiplication.service;

import com.itdeep.micorservices.socialmathematics.multiplication.domain.Multiplication;
import com.itdeep.micorservices.socialmathematics.multiplication.domain.MultiplicationResultAttempt;
import com.itdeep.micorservices.socialmathematics.multiplication.domain.User;
import com.itdeep.micorservices.socialmathematics.multiplication.event.EventDispatcher;
import com.itdeep.micorservices.socialmathematics.multiplication.event.MultiplicationSolvedEvent;
import com.itdeep.micorservices.socialmathematics.multiplication.repository.MultiplicationResultAttemptRepository;
import com.itdeep.micorservices.socialmathematics.multiplication.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
class MultiplicationServiceImpl implements MultiplicationService {

    private final RandomGeneratorService randomGeneratorService;

    private final MultiplicationResultAttemptRepository attemptRepository;
    private final UserRepository userRepository;
    private final EventDispatcher eventDispatcher;

    /**
     * @param randomGeneratorService will be injected automatically by Spring as
     * long as this class have only this constructor
     * @param attemptRepository
     * @param userRepository
     */
    @Autowired
    public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService,
            final MultiplicationResultAttemptRepository attemptRepository,
            final UserRepository userRepository,
            final EventDispatcher eventDispatcher) {
        this.randomGeneratorService = randomGeneratorService;
        this.attemptRepository = attemptRepository;
        this.userRepository = userRepository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Transactional
    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt attempt) {
        // Check if the user already exists for that alias
        Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());
        // Avoids 'hack' attempts
        Assert.isTrue(!attempt.isCorrect(), "You can't send anattempt marked as correct!!");

        // Check if the attempt is correct
        boolean isCorrect = attempt.getResultAttempt()
                == attempt.getMultiplication().
                        getFactorA()
                * attempt.getMultiplication().
                        getFactorB();
        MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(
                user.orElse(attempt.getUser()),
                attempt.getMultiplication(),
                attempt.getResultAttempt(),
                isCorrect
        );
        // Stores the attempt
        attemptRepository.save(checkedAttempt);
        // Communicates the result via Event
        eventDispatcher.send(
                new MultiplicationSolvedEvent(checkedAttempt.getId(),
                        checkedAttempt.getUser().getId(),
                        checkedAttempt.isCorrect())
        );

        return isCorrect;
    }

    @Override
    public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
        return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
    }

}
