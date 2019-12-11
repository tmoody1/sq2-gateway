package com.ravn.bookshop.controller;

import com.ravn.bookshop.BookClient;
import com.ravn.bookshop.ReviewClient;
import com.ravn.bookshop.model.Book;
import com.ravn.bookshop.model.Comment;
import com.ravn.bookshop.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration

public class GatewayController {

    @Autowired
    private ReviewClient reviewClient;

    @Autowired
    private BookClient bookClient;

    @RequestMapping(value = "/books", produces = { MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public List<Book> allBooks(){

        List<Book> books = bookClient.getBooks();

        for (Book book : books) {
            book.setReviews(reviewClient.getReviews(book.getIsbn()));
        }

        return books;
    }

    @RequestMapping(value = "/books/{id}/reviews", produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<Review> reviewsForBook(@PathVariable String id) {
        return reviewClient.getReviews("123");
    }


    @PostMapping(value = "/review/{id}/comment", produces = { MediaType.APPLICATION_JSON_VALUE}, consumes = { MediaType.APPLICATION_JSON_VALUE})
    public Comment commentForReview(@PathVariable String id, @RequestBody Comment comment) {
        return comment;
    }

    @PutMapping("/review/{id}/like")
    public void likeForReview(@PathVariable String id) {
        reviewClient.like(id);
    }


}
