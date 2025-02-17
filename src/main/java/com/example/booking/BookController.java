package com.example.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository repo;

    @GetMapping("/book")
    List<Book> book() {
        return repo.findAll();
    }

    @GetMapping("/bookingisbn/{isbn}")
    List<Book> findByIsbn(@PathVariable String isbn) {
        return repo.findByIsbn(isbn);
    }

    @GetMapping("/bookingtitle/{title}")
    List<Book> findByTitle(@PathVariable String title) {
        return repo.findByTitle(title);
    }

    @GetMapping("/bookpagecount/{ing1}/{ing2}")
    List<Book> findByPageCount(@PathVariable int ing1, @PathVariable int ing2) {
        return repo.findByPageCount(ing1, ing2);
    }
}
