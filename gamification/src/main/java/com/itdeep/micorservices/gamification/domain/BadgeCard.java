/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdeep.micorservices.gamification.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This class links a Badge to a User. Contains also a timestamp with the moment
 * in which the user got it.
 *
 * @author Akrem AYADI
 */
@Entity
public class BadgeCard {

    @Id
    @GeneratedValue
    @Column(name = "BADGE_ID")
    private final Long badgeId;

    private final Long userId;
    private final long badgeTimestamp;
    private final Badge badge;

    public BadgeCard(Long badgeId, Long userId, long badgeTimestamp, Badge badge) {
        this.badgeId = badgeId;
        this.userId = userId;
        this.badgeTimestamp = badgeTimestamp;
        this.badge = badge;
    }

    // Empty constructor for JSON / JPA
    public BadgeCard() {
        this(null, null, 0, null);
    }

    public BadgeCard(final Long userId, final Badge badge) {
        this(null, userId, System.currentTimeMillis(), badge);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.userId);
        hash = 41 * hash + (int) (this.badgeTimestamp ^ (this.badgeTimestamp >>> 32));
        hash = 41 * hash + Objects.hashCode(this.badge);
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
        final BadgeCard other = (BadgeCard) obj;
        if (this.badgeTimestamp != other.badgeTimestamp) {
            return false;
        }
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        if (this.badge != other.badge) {
            return false;
        }
        return true;
    }

    public Long getBadgeId() {
        return badgeId;
    }

    public Long getUserId() {
        return userId;
    }

    public long getBadgeTimestamp() {
        return badgeTimestamp;
    }

    public Badge getBadge() {
        return badge;
    }

}
