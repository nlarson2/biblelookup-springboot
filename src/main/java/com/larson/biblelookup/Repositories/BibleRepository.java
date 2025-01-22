package com.larson.biblelookup.Repositories;

import java.util.Optional;

import com.larson.biblelookup.Models.Bible;

public interface BibleRepository extends CrudRepository<Bible, Integer>{

    Optional<Bible> findByName(String name);
    
}
