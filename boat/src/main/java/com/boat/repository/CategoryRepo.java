/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.repository;

import com.boat.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public class CategoryRepo {
    @Autowired
    private CategoryRepository crud;
    
    public List<Category> getAll(){
        return (List<Category>) crud.findAll();
    }
    public Optional <Category> getCategory(int id){
        return crud.findById(id);
    }
    public Category save(Category categorys){
        return crud.save(categorys);
    }

    
}
