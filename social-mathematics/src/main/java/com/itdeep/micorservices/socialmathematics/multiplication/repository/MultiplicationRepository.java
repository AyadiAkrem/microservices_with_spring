/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itdeep.micorservices.socialmathematics.multiplication.repository;

import com.itdeep.micorservices.socialmathematics.multiplication.domain.Multiplication;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Akrem AYADI
 */
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long>{
    
}
