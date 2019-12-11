package com.ravn.bookshop.controller;

import com.ravn.bookshop.BookClient;
import com.ravn.bookshop.ReviewClient;
import com.ravn.bookshop.model.Book;
import com.ravn.bookshop.model.Comment;
import com.ravn.bookshop.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@EnableAutoConfiguration

public class GatewayController {

    @Autowired
    private ReviewClient reviewClient;

    @Autowired
    private BookClient bookClient;

    @RequestMapping("/books")
    @CrossOrigin
    public List<Book> allBooks(){

        List<Book> books = bookClient.getBooks();

        for (Book book : books) {
            book.setReviews(reviewClient.getReviews(book.getIsbn()));
        }

        return books;
    }

    @RequestMapping("/books/{id}/reviews")
    public List<Review> reviewsForBook(@PathVariable String id) {
        return reviewClient.getReviews("123");
    }


    @PostMapping("/review/{id}/comment")
    public Comment commentForReview(@PathVariable String id, @RequestBody Comment comment) {
        return comment;
    }

    @PutMapping("/review/{id}/like")
    public void likeForReview(@PathVariable String id) {
        reviewClient.like(id);
    }


}
