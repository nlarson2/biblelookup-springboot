package com.larson.biblelookup.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.larson.biblelookup.Models.Bible;

public interface BibleRepository extends JpaRepository<Bible, Integer>{

    Optional<Bible> findByName(String name);
    
}
