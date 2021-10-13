/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.repository;


import com.boat.model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jquiroga
 */
@Repository
public class ScoreRepo {
    @Autowired
    private ScoreRepository crud;
    
    public List<Score> getAll(){
        return (List<Score>) crud.findAll();
    }
    public Optional <Score> getScore(int idScore){
        return crud.findById(idScore);
    }
    public Score save(Score scores){
        return crud.save(scores);
    }

    
}
