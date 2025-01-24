package com.larson.biblelookup.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.larson.biblelookup.Models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
  Optional<Book> findByName(String name);
}
