/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdeep.micorservices.gamification.service.impl;

import com.itdeep.micorservices.gamification.domain.LeaderBoardRow;
import com.itdeep.micorservices.gamification.repository.ScoreCardRepository;
import com.itdeep.micorservices.gamification.service.LeaderBoardService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Retrieve the top 10 users with the highest score
 *
 * @author Akrem AYADI
 */
@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {

    private ScoreCardRepository scoreCardRepository;

    LeaderBoardServiceImpl(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    @Override
    public List<LeaderBoardRow> getCurrentLeaderBoard() {
        return scoreCardRepository.findFirst10();
    }

}
