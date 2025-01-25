package com.larson.versesearch.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.larson.versesearch.Models.Bible;

public interface BibleRepository extends JpaRepository<Bible, Integer>{

    Optional<Bible> findByName(String name);
    
}
