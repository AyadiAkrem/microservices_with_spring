/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdeep.micorservices.socialmathematics.multiplication.event;

import com.itdeep.micorservices.socialmathematics.multiplication.domain.Multiplication;
import java.io.Serializable;
import java.util.Objects;

/**
 * Event that models the fact that a {@link Multiplication} has been solved in
 * the system. Provides some context information about the multiplication.
 *
 * This class is immutable.
 *
 * @author Akrem AYADI
 */
public class MultiplicationSolvedEvent implements Serializable {

    private final Long multiplicationResultAttemptId;
    private final Long userId;
    private final boolean correct;

    public MultiplicationSolvedEvent(Long multiplicationResultAttemptId, Long userId, boolean correct) {
        this.multiplicationResultAttemptId = multiplicationResultAttemptId;
        this.userId = userId;
        this.correct = correct;
    }

    public Long getMultiplicationResultAttemptId() {
        return multiplicationResultAttemptId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isCorrect() {
        return correct;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.multiplicationResultAttemptId);
        hash = 53 * hash + Objects.hashCode(this.userId);
        hash = 53 * hash + (this.correct ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MultiplicationSolvedEvent other = (MultiplicationSolvedEvent) obj;
        if (this.correct != other.correct) {
            return false;
        }
        if (!Objects.equals(this.multiplicationResultAttemptId, other.multiplicationResultAttemptId)) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MultiplicationSolvedEvent{" + "multiplicationResultAttemptId=" + multiplicationResultAttemptId + ", userId=" + userId + ", correct=" + correct + '}';
    }

}
