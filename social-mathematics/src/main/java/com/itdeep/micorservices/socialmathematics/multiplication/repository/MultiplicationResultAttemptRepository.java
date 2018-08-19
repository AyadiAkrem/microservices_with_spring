/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdeep.micorservices.socialmathematics.multiplication.repository;

import com.itdeep.micorservices.socialmathematics.multiplication.domain.MultiplicationResultAttempt;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Akrem AYADI
 */
public interface MultiplicationResultAttemptRepository extends CrudRepository<MultiplicationResultAttempt, Long> {

    /**
     * @return the latest 5 attempts for a given user, identified by their
     * alias.
     */
    List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByIdDesc(String userAlias);

}
