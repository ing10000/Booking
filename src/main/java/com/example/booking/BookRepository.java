package com.example.booking;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{'isbn' : ?0}")
    List<Book> findByIsbn(String isbn);

    @Query("{'title' : {$regex : ?0}}")
    List<Book> findByTitle(String title);

    @Query("{'pageCount' : {$gte : ?0 ,$lte: ?1}}")
    List<Book> findByPageCount(int gte, int lte);
}
