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
 *@author Akrem AYADI
 */
public enum Badge {

    // Badges depending on score
    BRONZE_MULTIPLICATOR,
    SILVER_MULTIPLICATOR,
    GOLD_MULTIPLICATOR,
    // Other badges won for different conditions
    FIRST_ATTEMPT,
    FIRST_WON,
    LUCKY_NUMBER

}
