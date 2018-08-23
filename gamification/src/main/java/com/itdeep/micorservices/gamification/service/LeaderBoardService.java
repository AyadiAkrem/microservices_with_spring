/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdeep.micorservices.gamification.service;

import com.itdeep.micorservices.gamification.domain.LeaderBoardRow;
import java.util.List;

/**
 *
 * @author Akrem AYADI
 */
public interface LeaderBoardService {
    
    /**
     * Retrieves the current leader board with the top score users
     *
     * @return the users with the highest score
     */
    List<LeaderBoardRow> getCurrentLeaderBoard();
    
}
