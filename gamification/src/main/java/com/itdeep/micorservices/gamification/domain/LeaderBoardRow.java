/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdeep.micorservices.gamification.domain;

/**
 * Represents a line in our Leaderboard: it links a user to a total score.
 *
 * @author Akrem AYADI
 */
public final class LeaderBoardRow {

    private final Long userId;
    private final Long totalScore;

    // Empty constructor for JSON / JPA
    public LeaderBoardRow() {
        this(0L, 0L);
    }

    public LeaderBoardRow(Long userId, Long totalScore) {
        this.userId = userId;
        this.totalScore = totalScore;
    }
    
    
}
