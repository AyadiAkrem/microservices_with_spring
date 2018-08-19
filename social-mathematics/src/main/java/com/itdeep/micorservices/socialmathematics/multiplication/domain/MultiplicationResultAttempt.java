package com.itdeep.micorservices.socialmathematics.multiplication.domain;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Identifies the attempt from a {@link User} to solve a {@link Multiplication}.
 */
@Entity
public class MultiplicationResultAttempt {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private final User user;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MULTIPLICATION_ID")
    private final Multiplication multiplication;
    private final int resultAttempt;

    private final boolean correct;

    // Empty constructor for JSON (de)serialization
    MultiplicationResultAttempt() {
        this(null, null, -1);
    }

    public MultiplicationResultAttempt(User user, Multiplication multiplication, int resultAttempt) {
        this(user, multiplication, resultAttempt, false);
    }

    public MultiplicationResultAttempt(User user, Multiplication multiplication, int resultAttempt, boolean correct) {
        this.user = user;
        this.multiplication = multiplication;
        this.resultAttempt = resultAttempt;
        this.correct = correct;
    }

    public User getUser() {
        return user;
    }

    public Multiplication getMultiplication() {
        return multiplication;
    }

    public int getResultAttempt() {
        return resultAttempt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return correct;
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
        final MultiplicationResultAttempt other = (MultiplicationResultAttempt) obj;
        if (this.resultAttempt != other.resultAttempt) {
            return false;
        }
        if (this.correct != other.correct) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.multiplication, other.multiplication)) {
            return false;
        }
        return true;
    }
    
    
    
    

}
