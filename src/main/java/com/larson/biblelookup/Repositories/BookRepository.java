package com.larson.biblelookup.Repositories;

import java.util.Optional;

import com.larson.biblelookup.Models.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
      
  Optional<Book> findByName(String name);
}
