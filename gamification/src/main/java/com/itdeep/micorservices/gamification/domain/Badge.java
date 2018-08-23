/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdeep.micorservices.gamification.domain;

/**
 *
 * Enumeration with the different types of Badges that a user can win.
 *
 * @author Akrem AYADI
 */
public enum Badge {

    // Badges depending on score
    BRONZE_MULTIPLICATOR(100),
    SILVER_MULTIPLICATOR(500),
    GOLD_MULTIPLICATOR(999),
    // Other badges won for different conditions
    FIRST_ATTEMPT(-1),
    FIRST_WON(-1),
    LUCKY_NUMBER(-1);

    private final int score;

    private Badge(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

}
